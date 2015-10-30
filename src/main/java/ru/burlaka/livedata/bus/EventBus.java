package ru.burlaka.livedata.bus;

public interface EventBus {

	void subscribe(Listener listener);
}
