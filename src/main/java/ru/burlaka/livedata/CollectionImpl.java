package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionImpl extends Observable implements Collection {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollectionImpl.class);

	private static final KeyFactory keyFactory = new UUIDKeyFactory();

	/**
	 * Унакальный идентификатор коллекции.
	 */
	private Key id;

	/**
	 * Имя коллекции.
	 */
	private String name;

	/**
	 * Имя поля -> поле.
	 */
	private Map<String, Field> fieldsByName = new HashMap<>();

	private BackedCollection bc = new SimpleCollection();

	@Override
	public Key getKey() {
		return id;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : id.toString();
	}

	@Override
	public void put(Map<String, Object> fields) {
		put(keyFactory.newKey(), fields);
	}

	@Override
	public void put(Key key, Map<String, Object> fields) {
		StorableObject storableObject = new StorableObject();
		fields.forEach((fieldName, fieldValue) -> {
			Field field = fieldsByName.get(fieldName);
			if (field != null) {
				if (field.getType() == FieldType.CALCULATED) {
					EvalField evalField = (EvalField) field;
					storableObject.set(fieldName, evalField.eval());
				} else {
					DataField dataField = (DataField) field;
					if (dataField.validate(fieldValue)) {
						storableObject.set(fieldName, fieldValue);
					}
				}
			}
		});

		bc.put(storableObject);

		setChanged();
		LOGGER.info("Put object: {} into collection. New size: {}", fields, bc.size());

		notifyObservers(new PutEvent(storableObject));
	}

	@Override
	public Serializable get(Key key) {
		return bc.get(key);
	}

	@Override
	public Serializable remove(Key key) {
		Serializable object = bc.remove(key);
		setChanged();
		LOGGER.info("Remove object: {} from collection: {}", object, this);

		notifyObservers(new RemoveEvent(object));

		return object;
	}

	@Override
	public void subscribe(CollectionListener listener) {
		addObserver(listener);
	}

	@Override
	public void addField(Field field) {
		fieldsByName.put(field.getName(), field);
	}

	@Override
	public void removeField(Field field) {
		// TODO:
		throw new NotImplementedException();
	}

	@Override
	public String toString() {
		return bc.toString();
	}
}
