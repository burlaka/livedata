package ru.burlaka.livedata.test;

import ru.burlaka.livedata.Function;
import ru.burlaka.livedata.StorableObject;

public class SumFunction implements Function {

	private String fieldName1;

	private String fieldName2;

	public SumFunction(String fieldName1, String fieldName2) {
		this.fieldName1 = fieldName1;
		this.fieldName2 = fieldName2;
	}

	@Override
	public Object eval(StorableObject object) {
		return (Integer) object.get(fieldName1) + (Integer) object.get(fieldName2);
	}

}
