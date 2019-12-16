package com.djedra.shop.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
//@IdClass(Article.class)
public class Warranty {

	private static final long serialVersionUID = 2827632585139610033L;

//	z kluczem w tabeli Warranty nie działa??
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;

//	z kluczem wspoldzielonym - nie działa
	@Id
	@Column(name = "warranty_id")
	private Long id;

	@Column
	private String description;

	@Column
	private LocalDate warrantyAwardDate;

	@Column
	private LocalDate warrantyExpirationDate;

	/**
	 * https://www.baeldung.com/jpa-one-to-one
	 */

//	z kluczem w tabeli Warranty nie działa??
//	@OneToOne(mappedBy = "warranty")
//	private Article article;

//	z kluczem wspoldzielonym-nie działa nie dodaje
	@MapsId
	@OneToOne()
	private Article article;

	/**
	 * https://stackoverflow.com/questions/6833370/jpa-onetoone-with-shared-id-can-i-do-this-better
	 */
//	Joel Hudon:
//	@MapsId
//	@OneToOne(mappedBy = "warranty")
//	@JoinColumn(name = "warranty_id") // same name as id @Column
//	private Article article;

//	camposer:
//	@MapsId
//	@OneToOne()
//	@JoinColumn(name = "warranty_id") // same name as id @Column
//	private Article article;
}
