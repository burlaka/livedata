package ru.burlaka.livedata;

import java.util.Set;

public interface Field {

	Key getId();

	String getName();

	FieldType getType();

	Set<Field> getDependencies();

}
