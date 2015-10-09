package ru.burlaka.livedata;

import java.util.HashSet;
import java.util.Set;

public class EvalFieldImpl extends AbstractField implements EvalField {

	private static final long serialVersionUID = -8334739252927485519L;

	/**
	 * Listen on changes in the fields.
	 */
	private Set<Field> dependencies = new HashSet<>();

	private Function function;

	public EvalFieldImpl(String name) {
		super(name);
	}

	public EvalFieldImpl(String name, Function function) {
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
	public void subscribe(Field field) {
		dependencies.add(field);
	}

	@Override
	public Set<Field> dependencies() {
		return dependencies;
	}

}
