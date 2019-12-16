package com.djedra.shop.datafactory;

import java.time.LocalDate;

import com.djedra.shop.entity.Warranty;

public class WarrantyTestDataFactory {

	public static Warranty getStorage(String description, LocalDate warrantyAwardDate,
			LocalDate warrantyExpirationDate) {
		Warranty warranty = new Warranty();
		warranty.setDescription(description);
		warranty.setWarrantyAwardDate(warrantyAwardDate);
		warranty.setWarrantyExpirationDate(warrantyExpirationDate);
		return warranty;
	}
}
