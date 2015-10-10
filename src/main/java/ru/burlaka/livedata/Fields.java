package ru.burlaka.livedata;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

public class Fields {

	/**
	 * Поля содержащие данные. Имя поля -> поле.
	 */
	private Map<String, DataField> dataFieldsByName = new HashMap<>();

	/**
	 * Вычисляемые поля. Имя поля -> поле.
	 */
	private Map<String, EvalField> evalFieldsByName = new HashMap<>();

	/**
	 * Граф полей для контроля циклических ссылок.
	 */
	private DirectedAcyclicGraph<Field, DefaultEdge> fields = new DirectedAcyclicGraph<Field, DefaultEdge>(
			DefaultEdge.class);

	public DataField dataField(String fieldName) {
		return dataFieldsByName.get(fieldName);
	}

	public Map<String, DataField> dataFields() {
		return Collections.unmodifiableMap(dataFieldsByName);
	}

	public EvalField evalField(String fieldName) {
		return evalFieldsByName.get(fieldName);
	}

	public Map<String, EvalField> evalFields() {
		return Collections.unmodifiableMap(evalFieldsByName);
	}

	public void put(DataField field) {
		fields.addVertex(field);
		dataFieldsByName.put(field.getName(), field);
	}

	public void put(EvalField field) {
		fields.addVertex(field);
		field.dependencies().stream().forEach(dependency -> {
			try {
				fields.addEdge(dependency, field);
			} catch (IllegalArgumentException e) {
				throw new CycleDependenciesException(e);
			}
		});
		evalFieldsByName.put(field.getName(), field);
	}

	public boolean hasPath(DataField dataField, EvalField evalField) {
		List<DefaultEdge> path = DijkstraShortestPath.findPathBetween(fields, dataField, evalField);
		return path == null ? false : true;
	}
}
