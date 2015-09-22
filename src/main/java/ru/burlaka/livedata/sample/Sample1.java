package ru.burlaka.livedata.sample;

import java.util.HashMap;
import java.util.Map;

import ru.burlaka.livedata.Collection;
import ru.burlaka.livedata.CollectionImpl;
import ru.burlaka.livedata.View;
import ru.burlaka.livedata.ViewImpl;

public class Sample1 {

	public static void main(String[] args) {
		Collection collection = new CollectionImpl();
		View view = new ViewImpl();
		collection.subscribe(view);

		Map<String, Object> map = new HashMap<>();
		map.put("field1", "aaa");
		collection.put(map);
	}

}
