package ru.burlaka.livedata;

import java.util.HashMap;
import java.util.Map;

public class SimpleCollection implements BackendCollection {

	private Map<Key, StorableObject> data = new HashMap<>();

	@Override
	public StorableObject get(Key key) {
		return data.get(key);
	}

	@Override
	public void put(StorableObject storableObject) {
		data.put(storableObject.getId(), storableObject);
	}

	@Override
	public StorableObject remove(Key key) {
		return data.remove(key);
	}

	@Override
	public long size() {
		return data.size();
	}

	@Override
	public String toString() {
		return "SimpleCollection [data=" + data + "]";
	}

}
