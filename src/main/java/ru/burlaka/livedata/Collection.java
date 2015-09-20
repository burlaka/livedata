package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.Map;

/**
 * Интерфейс для доступа к объектам.
 * 
 * @author Denis Burlaka
 *
 */
public interface Collection {

	Key getKey();

	String getName();

	/**
	 * Store set of pairs into collection.
	 * 
	 * @param object
	 */
	void put(Map<String, Object> fields);

	void put(Key key, Map<String, Object> fields);

	Serializable get(Key key);

	Serializable remove(Key key);

	void subscribe(CollectionListener listener);

	void addField(DataField field);

	void addField(EvalField field);

	void removeField(Field field);

}
