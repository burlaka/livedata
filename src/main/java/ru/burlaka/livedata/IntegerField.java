package ru.burlaka.livedata;

public class IntegerField extends AbstractField implements DataField {

	private static final long serialVersionUID = -1831958843875060514L;

	public IntegerField(String name) {
		super(name);
	}

	@Override
	public FieldType getType() {
		return FieldType.INTEGER;
	}

	@Override
	public boolean validate(Object fieldValue) {
		return true;
	}

}
