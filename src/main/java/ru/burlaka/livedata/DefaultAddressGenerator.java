package ru.burlaka.livedata;

public class DefaultAddressGenerator implements AddressGenerator {

	@Override
	public String generate(LiveObject liveObject) {
		return liveObject.getName();
	}

}
