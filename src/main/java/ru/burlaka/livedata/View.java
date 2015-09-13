package ru.burlaka.livedata;

import java.io.Serializable;

/**
 * Интерфейс денормализованной коллекции объектов.
 * 
 * @author Denis Burlaka
 *
 */
public interface View {

	Key getKey();

	String getName();

	Serializable get(Key key);

}
