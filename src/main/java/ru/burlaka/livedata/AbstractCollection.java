package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractCollection extends Observable implements Collection {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCollection.class);

	private Key key;

	private String name;

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : key.toString();
	}

	@Override
	public void put(Serializable object) {
		doPut(object);
		setChanged();
		LOGGER.info("Put object: {} into collection: {}", object, this);

		notifyObservers(new PutEvent(object));
	}

	protected void doPut(Serializable object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Serializable get(Key key) {
		return doGet(key);
	}

	protected Serializable doGet(Key key2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable remove(Key key) {
		Serializable object = doRemove(key);
		setChanged();
		LOGGER.info("Remove object: {} from collection: {}", object, this);

		notifyObservers(new RemoveEvent(object));

		return object;
	}

	protected Serializable doRemove(Key key2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void subscribe(CollectionListener listener) {
		addObserver(listener);
	}

	@Override
	public String toString() {
		return "AbstractCollection [key=" + key + ", name=" + name + "]";
	}
}
