package com.djedra.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Long id;

	@Column
	private String name;

	@Column
	private double cost;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articleCategory_id", nullable = false)

	private ArticleCategory articleCategory;

	@ManyToOne
	@JoinColumn(name = "storage_id", nullable = false)
//	pole nie uzupełnione. Storage posiada listę artykułów
	@JsonBackReference
	private Storage storage;

	/**
	 * https://www.baeldung.com/jpa-one-to-one
	 */
//	oba nie nie działaja
//	z kluczem w tabeli Warranty 
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "warranty_id", referencedColumnName = "id")
//	private Warranty warranty;

//	z kluczem wspoldzielonym 
	@OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
	private Warranty warranty;

	/**
	 * https://stackoverflow.com/questions/6833370/jpa-onetoone-with-shared-id-can-i-do-this-better
	 */
//	Joel Hudon:
//	z kluczem wspoldzielonym ze stackOverflow
//	@PrimaryKeyJoinColumn
//	@OneToOne(cascade = CascadeType.ALL)
//	private Warranty warranty;

//	camposer:
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "article")
//	private Warranty warranty;
}
