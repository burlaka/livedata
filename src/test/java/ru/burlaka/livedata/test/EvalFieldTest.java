package ru.burlaka.livedata.test;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import ru.burlaka.livedata.Collection;
import ru.burlaka.livedata.CollectionImpl;
import ru.burlaka.livedata.DataField;
import ru.burlaka.livedata.DefaultEvalField;
import ru.burlaka.livedata.IntegerField;

public class EvalFieldTest {

	@Test
	public void test() {
		Collection col = new CollectionImpl();
		DataField f1 = new IntegerField("f1");
		col.addField(f1);
		DataField f2 = new IntegerField("f2");
		col.addField(f2);

		DefaultEvalField f3 = new DefaultEvalField("f3", new SumFunction());
		f3.subscribe(f1);
		f3.subscribe(f2);
		col.addField(f3);

		HashMap<String, Object> fields = new HashMap<>();
		fields.put("f1", 3);
		fields.put("f2", 5);
		col.put(fields);

		System.out.println(col.toString());
		Assert.assertEquals(1, col.size());
	}

}
