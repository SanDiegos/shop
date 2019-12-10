package com.djedra.shop.reporitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djedra.shop.entity.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

	Optional<Storage> findByName(String name);

}
