package ru.burlaka.livedata.bus;

public interface Consumer {

	void handle(Event event);
}
