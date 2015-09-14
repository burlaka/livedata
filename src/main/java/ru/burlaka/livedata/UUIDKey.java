package ru.burlaka.livedata;

import java.util.UUID;

public class UUIDKey implements Key {

	private static final long serialVersionUID = 320652964301439598L;

	private UUID value;

	public UUIDKey(UUID uuid) {
		this.value = uuid;
	}

	@Override
	public boolean equals(Key key) {
		return false;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
