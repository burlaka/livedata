package ru.burlaka.livedata;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ru.burlaka.livedata.bus.Consumer;
import ru.burlaka.livedata.bus.EventBus;

public class Metaspace {

	private Map<Key, LiveObject> objects = new ConcurrentHashMap<>();

	private EventBus eventBus = new DefaultEventBus();

	private AddressGenerator addressGenerator = new DefaultAddressGenerator();

	public Collection createCollection() {
		Collection collection = new CollectionImpl();
		objects.put(collection.getKey(), collection);
		eventBus.on(addressGenerator.generate(collection), (Consumer) collection);
		return collection;
	}

	public Structure createStructure() {
		Structure structure = new StructureImpl();
		objects.put(structure.getKey(), structure);
		return structure;
	}
}
