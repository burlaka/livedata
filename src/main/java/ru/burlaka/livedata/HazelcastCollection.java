package ru.burlaka.livedata;

public class HazelcastCollection implements BackendCollection {

	@Override
	public StorableObject get(Key key) {
		throw new NotImplementedException();
	}

	@Override
	public void put(StorableObject storableObject) {
		throw new NotImplementedException();
	}

	@Override
	public StorableObject remove(Key key) {
		throw new NotImplementedException();
	}

	@Override
	public long size() {
		throw new NotImplementedException();
	}

}
