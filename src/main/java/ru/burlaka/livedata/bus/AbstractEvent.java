package ru.burlaka.livedata.bus;

import java.io.Serializable;

public abstract class AbstractEvent {

	public abstract Serializable getObject();

}
