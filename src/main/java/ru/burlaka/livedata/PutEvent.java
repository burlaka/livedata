package ru.burlaka.livedata;

import java.io.Serializable;

public class PutEvent {

	private Serializable object;

	public PutEvent(Serializable object) {
		this.object = object;
	}

	protected Serializable getObject() {
		return object;
	}

	protected void setObject(Serializable object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "PutEvent [object=" + object + "]";
	}
}
