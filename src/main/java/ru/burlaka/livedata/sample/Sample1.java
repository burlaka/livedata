package ru.burlaka.livedata.sample;

import ru.burlaka.livedata.DefaultCollection;
import ru.burlaka.livedata.DefaultView;

public class Sample1 {

	public static void main(String[] args) {
		DefaultCollection col = new DefaultCollection();
		DefaultView view = new DefaultView();
		col.subscribe(view);

		col.put(new TestObject());
	}

}
