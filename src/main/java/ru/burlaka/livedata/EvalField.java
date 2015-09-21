package ru.burlaka.livedata;

public interface EvalField extends Field {

	void subscribe(DataField field);

	Object eval();

}
