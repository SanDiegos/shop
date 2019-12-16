package com.djedra.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djedra.shop.entity.Warranty;
import com.djedra.shop.facade.WarrantyFacade;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/warranty")
@RequiredArgsConstructor
public class WarrantyController {

	private final WarrantyFacade warrantyFacade;

	@GetMapping()
	public List<Warranty> get() throws Exception {
		return warrantyFacade.findAll();
	}

	@GetMapping("/{articleId}")
	public Optional<Warranty> getById(@PathVariable Long warrantyId) throws Exception {
		return warrantyFacade.findById(warrantyId);
	}

	@PostMapping()
	public Warranty add(@RequestBody Warranty warranty) {
		return warrantyFacade.save(warranty);
	}

	@DeleteMapping
	public void delete(@PathVariable Long warrantyId) {
		warrantyFacade.delete(warrantyId);
	}
}
