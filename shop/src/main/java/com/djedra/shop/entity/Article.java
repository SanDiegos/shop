package com.djedra.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
