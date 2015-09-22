package ru.burlaka.livedata.test;

import ru.burlaka.livedata.Function;
import ru.burlaka.livedata.StorableObject;

public class SumFunction implements Function {

	@Override
	public Object eval(StorableObject object) {
		return (Integer) object.get("f1") + (Integer) object.get("f2");
	}

}
