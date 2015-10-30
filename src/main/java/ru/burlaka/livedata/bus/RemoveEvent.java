package ru.burlaka.livedata.bus;

import java.io.Serializable;

public class RemoveEvent {

	private Serializable object;

	public RemoveEvent(Serializable object) {
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
		return "RemoveEvent []";
	}
}
