package ru.burlaka.livedata.test;

import java.io.Serializable;

import ru.burlaka.livedata.Function;

public class SumFunction implements Function {

	@Override
	public Serializable eval() {
		return 4;
	}

	@Override
	public Serializable eval(Serializable object) {
		// TODO Auto-generated method stub
		return null;
	}

}
