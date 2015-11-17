package ru.burlaka.livedata;

import java.util.Observable;

public class AbstractLiveObject extends Observable implements LiveObject {

	/**
	 * Уникальный идентификатор объекта.
	 */
	private Key id;

	/**
	 * Имя объекта.
	 */
	private String name;

	@Override
	public Key getKey() {
		return id;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : id.toString();
	}

	@Override
	public void subscribe(CollectionListener listener) {
		addObserver(listener);
	}
}
