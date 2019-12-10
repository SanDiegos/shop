package com.djedra.shop.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.djedra.shop.entity.ArticleCategory;
import com.djedra.shop.reporitory.ArticleCategoryRepository;

@Component
public class ArticleCategoryFacade {

	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;

	public ArticleCategory save(ArticleCategory articleCategory) {
		return articleCategoryRepository.save(articleCategory);
	}

	public List<ArticleCategory> findAll() {
		return articleCategoryRepository.findAll();
	}

	public Optional<ArticleCategory> findById(Long articleCategoryId) {
		return articleCategoryRepository.findById(articleCategoryId);
	}

	public Optional<ArticleCategory> findByCategory(String category) {
		return articleCategoryRepository.findByCategory(category);
	}

}
