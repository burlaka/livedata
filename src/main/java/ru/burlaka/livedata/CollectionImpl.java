package ru.burlaka.livedata;

import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;

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

	private Fields fields = new Fields();

	private BackedCollection bc = new SimpleCollection();

	private EventBus eventBus;

	@Override
	public Key getKey() {
		return id;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : id.toString();
	}

	@Override
	public Key put(Map<String, Object> fields) {
		return put(keyFactory.newKey(), fields);
	}

	@Override
	public Key put(Key key, Map<String, Object> pairs) {
		StorableObject storableObject = new StorableObject(keyFactory.newKey());
		pairs.forEach((fieldName, fieldValue) -> {
			DataField field = fields.dataField(fieldName);
			if (field != null) {
				if (field.validate(fieldValue)) {
					storableObject.set(fieldName, fieldValue);
				}
			} else {
				LOGGER.warn("No field with name={} found. Ingrored.", fieldName);
			}
		});

		// TODO: Вызывать только те функции, которые зависять от изменённых
		// полей. Сейчас вызываются все функции.
		fields.evalFields().forEach((fieldName, field) -> {
			storableObject.set(fieldName, field.eval(storableObject));
		});

		bc.put(storableObject);

		setChanged();
		LOGGER.info("Put object: {} into collection. New size: {}", pairs, bc.size());

		notifyObservers(new PutEvent(storableObject));
		return storableObject.getId();
	}

	@Override
	public StorableObject get(Key key) {
		return bc.get(key);
	}

	@Override
	public StorableObject remove(Key key) {
		StorableObject object = bc.remove(key);
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
	public void addField(DataField field) {
		fields.put(field);
	}

	@Override
	public void addField(EvalField field) {
		fields.put(field);
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

	@Override
	public long size() {
		return bc.size();
	}
}
