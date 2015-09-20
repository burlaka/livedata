package ru.burlaka.livedata.test;

import java.util.HashMap;

import org.junit.Test;

import ru.burlaka.livedata.Collection;
import ru.burlaka.livedata.CollectionImpl;
import ru.burlaka.livedata.DefaultEvalField;
import ru.burlaka.livedata.IntegerField;

public class EvalFieldTest {

	@Test
	public void test() {
		Collection col = new CollectionImpl();
		col.addField(new IntegerField("f1"));
		col.addField(new IntegerField("f2"));
		col.addField(new DefaultEvalField("f3", new SumFunction()));

		HashMap<String, Object> fields = new HashMap<>();
		fields.put("f1", 3);
		fields.put("f2", 5);
		col.put(fields);

		System.out.println(col.toString());
	}

}
