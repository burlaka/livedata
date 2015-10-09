package ru.burlaka.livedata;

public class CycleDependenciesException extends RuntimeException {

	private static final long serialVersionUID = -4532032643746830876L;

	public CycleDependenciesException(IllegalArgumentException e) {
		super(e);
	}

}
