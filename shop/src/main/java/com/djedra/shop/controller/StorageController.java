package com.djedra.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djedra.shop.entity.Storage;
import com.djedra.shop.facade.StorageFacade;

@RestController
@RequestMapping(value = "/storage")
@CrossOrigin
public class StorageController {

	@Autowired
	private StorageFacade storageFacade;

	@PostMapping()
	public Storage add(@RequestBody Storage storage) {
		return storageFacade.save(storage);
	}

	@GetMapping()
	public List<Storage> get() throws Exception {
		return storageFacade.findAll();
	}

	@GetMapping("/{storageId}")
	public Optional<Storage> getById(@PathVariable Long storageId) throws Exception {
		return storageFacade.findById(storageId);
	}

	@GetMapping("/get-by-Name")
	public Optional<Storage> getByName(@RequestParam(value = "name") String name) throws Exception {
		return storageFacade.findByCategory(name);
	}
}
