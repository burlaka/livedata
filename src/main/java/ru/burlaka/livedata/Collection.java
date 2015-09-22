package ru.burlaka.livedata;

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
	Key put(Map<String, Object> fields);

	Key put(Key key, Map<String, Object> fields);

	StorableObject get(Key key);

	StorableObject remove(Key key);

	void subscribe(CollectionListener listener);

	void addField(DataField field);

	void addField(EvalField field);

	void removeField(Field field);

	long size();

}
