package ru.burlaka.livedata;

import java.io.Serializable;

public class PutEvent extends AbstractEvent {

	private Serializable object;

	public PutEvent(Serializable object) {
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
