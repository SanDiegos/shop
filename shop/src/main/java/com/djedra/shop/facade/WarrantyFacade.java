package com.djedra.shop.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.djedra.shop.entity.Warranty;
import com.djedra.shop.reporitory.WarrantyRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WarrantyFacade {

	private final WarrantyRepository warrantyRepository;

	public List<Warranty> findAll() {
		return warrantyRepository.findAll();
	}

	public Optional<Warranty> findById(Long warrantyId) throws Exception {
		return warrantyRepository.findById(warrantyId);
	}

	public Warranty save(Warranty warranty) {
		return warrantyRepository.save(warranty);
	}

	public void delete(Long warrantyId) {
		warrantyRepository.deleteById(warrantyId);
	}
}
