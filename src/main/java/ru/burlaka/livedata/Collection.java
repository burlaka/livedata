package ru.burlaka.livedata;

import java.io.Serializable;

/**
 * Интерфейс для доступа к объектам.
 * 
 * @author Denis Burlaka
 *
 */
public interface Collection {

	Key getKey();

	String getName();

	void put(Serializable object);

	void put(Key key, Serializable object);

	Serializable get(Key key);

	Serializable remove(Key key);

}
