package ru.burlaka.livedata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Engine {

	private static final Logger LOGGER = LoggerFactory.getLogger(Engine.class);

	public void start() {
		LOGGER.info("Engine started.");
	}

	public void stop() {
		LOGGER.info("Engine stoped.");
	}
}
