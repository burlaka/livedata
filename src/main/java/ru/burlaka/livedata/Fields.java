package ru.burlaka.livedata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
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
	private DirectedGraph<Field, DefaultEdge> fields = new DefaultDirectedGraph<Field, DefaultEdge>(DefaultEdge.class);

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
		field.getDependencies().stream().forEach(dependecy -> {
			fields.addEdge(dependecy, field);
		});
		evalFieldsByName.put(field.getName(), field);
	}
}
