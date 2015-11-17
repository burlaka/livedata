package ru.burlaka.livedata.bus;

public interface EventBus {

	void on(String address, Consumer consumer);

}
