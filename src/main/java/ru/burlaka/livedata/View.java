package ru.burlaka.livedata;

import java.io.Serializable;

/**
 * Интерфейс денормализованной коллекции объектов.
 * 
 * @author Denis Burlaka
 *
 */
// TODO: убрать CollectionListener от сюда
public interface View extends CollectionListener {

	Key getKey();

	String getName();

	Serializable get(Key key);

	void setFunction(MapFunction function);

}
