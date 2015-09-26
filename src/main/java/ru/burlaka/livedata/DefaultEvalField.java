package ru.burlaka.livedata;

import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.Subscribe;

public class DefaultEvalField extends AbstractField implements EvalField {

	private static final long serialVersionUID = -8334739252927485519L;

	/**
	 * Listen on changes in the fields.
	 */
	private List<DataField> fields = new ArrayList<>();

	private Function function;

	public DefaultEvalField(String name) {
		super(name);
	}

	public DefaultEvalField(String name, Function function) {
		super(name);
		this.function = function;
	}

	@Override
	public FieldType getType() {
		return FieldType.CALCULATED;
	}

	@Override
	public Object eval(StorableObject object) {
		return function.eval(object);
	}

	@Override
	public void subscribe(DataField field) {
		fields.add(field);
	}

	@Subscribe
	public void recordCustomerChange() {
		System.out.println("asd");
	}

}
