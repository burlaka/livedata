package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.Map;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.burlaka.livedata.bus.AbstractEvent;

public class ViewImpl implements View {

	private static final Logger LOGGER = LoggerFactory.getLogger(ViewImpl.class);

	private Key key;

	private String name;

	private Collection data = new CollectionImpl();

	private MapFunction function;

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : key.toString();
	}

	@Override
	public void setFunction(MapFunction function) {
		this.function = function;
	}

	@Override
	public Serializable get(Key key) {
		return data.get(key);
	}

	@Override
	public void update(Observable collection, Object event) {
		LOGGER.info("Update event recieved: {}", event);

		if (function != null) {
			data.put(toMap(function.eval(((AbstractEvent) event).getObject())));
		}
	}

	private Map<String, Object> toMap(Object object) {
		return null;
	}
}
