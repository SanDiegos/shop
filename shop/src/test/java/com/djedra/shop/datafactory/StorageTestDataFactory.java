package com.djedra.shop.datafactory;

import com.djedra.shop.entity.Storage;

public class StorageTestDataFactory {

	public static Storage getStorage(String name) {
		Storage storage = new Storage();
		storage.setName(name);
		return storage;
	}
}
