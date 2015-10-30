package ru.burlaka.livedata.bus;

import java.io.Serializable;

import ru.burlaka.livedata.StorableObject;

public class PutEvent extends AbstractEvent {

	private StorableObject object;

	public PutEvent(StorableObject object) {
		this.object = object;
	}

	public Serializable getObject() {
		return object;
	}

	@Override
	public String toString() {
		return "PutEvent [object=" + object + "]";
	}
}
