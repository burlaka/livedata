package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractView implements View, CollectionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractView.class);

	private Key key;

	private String name;

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : key.toString();
	}

	@Override
	public Serializable get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Observable collection, Object event) {
		LOGGER.info("Update event recieved: {}", event);
	}

}
