package ru.burlaka.livedata.test;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import ru.burlaka.livedata.Collection;
import ru.burlaka.livedata.CollectionImpl;
import ru.burlaka.livedata.DataField;
import ru.burlaka.livedata.EvalFieldImpl;
import ru.burlaka.livedata.IntegerField;
import ru.burlaka.livedata.Key;
import ru.burlaka.livedata.StorableObject;

public class EvalFieldTest {

	@Test
	public void test() {
		Collection col = new CollectionImpl();
		DataField f1 = new IntegerField("f1");
		col.addField(f1);
		DataField f2 = new IntegerField("f2");
		col.addField(f2);

		EvalFieldImpl f3 = new EvalFieldImpl("f3", new SumFunction("f1", "f2"));
		f3.subscribe(f1);
		f3.subscribe(f2);
		col.addField(f3);

		EvalFieldImpl f4 = new EvalFieldImpl("f4", new SumFunction("f1", "f3"));
		f4.subscribe(f1);
		f4.subscribe(f3);
		col.addField(f4);

		EvalFieldImpl f5 = new EvalFieldImpl("f5", new SumFunction("f3", "f4"));
		f5.subscribe(f3);
		f5.subscribe(f4);
		col.addField(f5);

		// put object in collection
		HashMap<String, Object> fields = new HashMap<>();
		fields.put("f1", 3);
		fields.put("f2", 5);
		Key id = col.put(fields);

		// get object from collection with evaluated fields
		StorableObject object = col.get(id);

		System.out.println(col.toString());
		Assert.assertEquals(1, col.size());
		Assert.assertNotNull(object.getId());
		Assert.assertEquals(3, object.get("f1"));
		Assert.assertEquals(5, object.get("f2"));
		Assert.assertEquals(8, object.get("f3"));
		Assert.assertEquals(11, object.get("f4"));
		Assert.assertEquals(19, object.get("f5"));
	}

}
