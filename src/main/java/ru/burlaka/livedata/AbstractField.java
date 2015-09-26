package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.Set;

public abstract class AbstractField implements Field, Serializable {

	private static final long serialVersionUID = 4717581508406239433L;

	private Key id;

	private String name;

	private Set<Field> dependencies;

	public AbstractField(String name) {
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

	@Override
	public Set<Field> getDependencies() {
		return dependencies;
	}

}
