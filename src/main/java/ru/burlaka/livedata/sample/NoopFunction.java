package ru.burlaka.livedata.sample;

import java.io.Serializable;

import ru.burlaka.livedata.Function;

public class NoopFunction implements Function {

	@Override
	public Serializable eval(Serializable object) {
		System.out.println(object);
		return object;
	}

}
