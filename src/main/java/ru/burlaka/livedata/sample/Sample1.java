package ru.burlaka.livedata.sample;

import ru.burlaka.livedata.DefaultCollection;
import ru.burlaka.livedata.DefaultView;

public class Sample1 {

	public static void main(String[] args) {
		DefaultCollection collection = new DefaultCollection();
		DefaultView view = new DefaultView();
		view.setFunction(new NoopFunction());
		collection.subscribe(view);

		collection.put(new TestObject());
	}

}
