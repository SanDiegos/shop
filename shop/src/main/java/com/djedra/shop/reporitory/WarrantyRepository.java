package com.djedra.shop.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djedra.shop.entity.Warranty;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Long> {

}
