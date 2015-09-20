package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StorableObject implements Serializable {

	private static final long serialVersionUID = 3408166543140666788L;

	private Key id;

	private Map<Key, Field> fields = new HashMap<>();

	private Map<String, Object> values = new HashMap<>();

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public void set(String key, Object value) {
		values.put(key, value);
	}

	@Override
	public String toString() {
		return "StorableObject [id=" + id + ", fields=" + fields + ", values=" + values + "]";
	}

}
