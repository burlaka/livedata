package ru.burlaka.livedata;

public interface BackendCollection {

	StorableObject get(Key key);

	void put(StorableObject storableObject);

	StorableObject remove(Key key);

	long size();

}
