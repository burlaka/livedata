package ru.burlaka.livedata;

public interface LiveObject {

	Key getKey();

	String getName();

	void subscribe(CollectionListener listener);

}
