package ru.burlaka.livedata;

import java.util.ArrayList;
import java.util.List;

import ru.burlaka.livedata.test.SumFunction;

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

	public DefaultEvalField(String name, SumFunction function) {
		super(name);
		this.function = function;
	}

	@Override
	public FieldType getType() {
		return FieldType.CALCULATED;
	}

	@Override
	public Object eval() {
		return function.eval();
	}

	@Override
	public void subscribe(DataField field) {
		fields.add(field);
	}

}
