package ru.burlaka.livedata;

import java.util.UUID;

public class UUIDKeyFactory implements KeyFactory {

	@Override
	public Key newKey() {
		return new UUIDKey(UUID.randomUUID());
	}

}
