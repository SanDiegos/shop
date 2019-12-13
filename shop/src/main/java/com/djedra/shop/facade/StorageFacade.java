package com.djedra.shop.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.djedra.shop.entity.Storage;
import com.djedra.shop.reporitory.StorageRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StorageFacade {

	private final StorageRepository storageRepository;

	public Storage save(Storage storage) {
		return storageRepository.save(storage);
	}

	public List<Storage> findAll() {
		return storageRepository.findAll();
	}

	public Optional<Storage> findById(Long storageId) {
		return storageRepository.findById(storageId);
	}

	public Optional<Storage> findByCategory(String name) {
		return storageRepository.findByName(name);
	}

}
