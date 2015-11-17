package ru.burlaka.livedata;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.burlaka.livedata.bus.Consumer;
import ru.burlaka.livedata.bus.Event;
import ru.burlaka.livedata.bus.PutEvent;
import ru.burlaka.livedata.bus.RemoveEvent;

public class CollectionImpl extends AbstractLiveObject implements Collection, Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollectionImpl.class);

	private static final KeyFactory keyFactory = new UUIDKeyFactory();

	private Fields fields = new Fields();

	private BackendCollection bc = new SimpleCollection();

	@Override
	public Key put(Map<String, Object> pairs) {
		return put(keyFactory.newKey(), pairs);
	}

	@Override
	public Key put(Key key, Map<String, Object> pairs) {
		if (key == null) {
			throw new IllegalArgumentException();
		}

		if (pairs == null) {
			throw new IllegalArgumentException();
		}

		StorableObject storedObject = bc.get(key);
		if (storedObject == null) {
			storedObject = new StorableObject(key);
		}

		Set<DataField> changedFields = new HashSet<>();
		for (Entry<String, Object> pair : pairs.entrySet()) {
			DataField field = fields.dataField(pair.getKey());
			if (field != null) {
				if (field.validate(pair.getValue())) {
					storedObject.set(pair.getKey(), pair.getValue());
					changedFields.add(field);
				}
			} else {
				LOGGER.warn("No field with name={} found. Will be Ingrored.", pair.getKey());
			}
		}

		for (DataField dataField : changedFields) {
			for (EvalField evalField : fields.evalFields().values()) {
				if (fields.hasPath(dataField, evalField)) {
					storedObject.set(evalField.getName(), evalField.eval(storedObject));
				}
			}
		}

		bc.put(storedObject);

		setChanged();
		LOGGER.info("Put object: {} into collection. Collection size: {}", pairs, bc.size());

		notifyObservers(new PutEvent(storedObject));
		return storedObject.getId();
	}

	@Override
	public StorableObject get(Key key) {
		return bc.get(key);
	}

	@Override
	public StorableObject remove(Key key) {
		StorableObject object = bc.remove(key);
		setChanged();
		LOGGER.info("Remove object: {} from collection: {}", object, this);

		notifyObservers(new RemoveEvent(object));

		return object;
	}

	@Override
	public void addField(DataField field) {
		fields.put(field);
	}

	@Override
	public void addField(EvalField field) {
		fields.put(field);
	}

	@Override
	public void removeField(Field field) {
		// TODO:
		throw new NotImplementedException();
	}

	@Override
	public String toString() {
		return bc.toString();
	}

	@Override
	public long size() {
		return bc.size();
	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
	}
}
