package ru.burlaka.livedata;

import java.io.Serializable;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.burlaka.livedata.sample.NoopFunction;

public class AbstractView implements View, CollectionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractView.class);

	private Key key;

	private String name;

	private Collection data = new DefaultCollection();

	private Function function;

	@Override
	public Key getKey() {
		return key;
	}

	@Override
	public String getName() {
		return (name != null && !name.isEmpty()) ? name : key.toString();
	}

	public void setFunction(NoopFunction function) {
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
			data.put(function.eval(((AbstractEvent) event).getObject()));
		}
	}

}
