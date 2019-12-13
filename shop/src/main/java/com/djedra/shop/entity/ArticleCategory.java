package com.djedra.shop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class ArticleCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String category;

//	pole nie uzupełnione. Kategoria nie powinna zwracać artykułu
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "articleCategory", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Article> article;

}
