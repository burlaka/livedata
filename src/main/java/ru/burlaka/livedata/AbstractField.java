package ru.burlaka.livedata;

import java.io.Serializable;

public abstract class AbstractField implements Field, Serializable {

	private static final long serialVersionUID = 4717581508406239433L;

	private KeyFactory keyFactory = new UUIDKeyFactory();

	private Key id;

	private String name;

	public AbstractField(String name) {
		this.id = keyFactory.newKey();
		this.name = name;
	}

	@Override
	public Key getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

}
