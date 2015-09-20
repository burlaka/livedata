package ru.burlaka.livedata;

import ru.burlaka.livedata.test.SumFunction;

public class DefaultEvalField extends AbstractField implements EvalField {

	private static final long serialVersionUID = -8334739252927485519L;

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

}
