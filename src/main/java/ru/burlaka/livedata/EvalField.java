package ru.burlaka.livedata;

import java.util.Set;

public interface EvalField extends Field {

	void subscribe(Field field);

	Object eval(StorableObject object);

	Set<Field> dependencies();

}
