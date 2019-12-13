package com.djedra.shop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djedra.shop.entity.ArticleCategory;
import com.djedra.shop.facade.ArticleCategoryFacade;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/articleCategory")
@CrossOrigin
@RequiredArgsConstructor
public class ArticleCategoryController {

	private final ArticleCategoryFacade articleCategoryFacade;

	@PostMapping()
	public ArticleCategory add(@RequestBody ArticleCategory articleCategory) {
		return articleCategoryFacade.save(articleCategory);
	}

	@GetMapping()
	public List<ArticleCategory> get() throws Exception {
		return articleCategoryFacade.findAll();
	}

	@GetMapping("/{articleCategoryId}")
	public Optional<ArticleCategory> getById(@PathVariable Long articleCategoryId) throws Exception {
		return articleCategoryFacade.findById(articleCategoryId);
	}

	@GetMapping("/get-by-category")
	public Optional<ArticleCategory> getByCategory(@RequestParam(value = "category") String category) throws Exception {
		return articleCategoryFacade.findByCategory(category);
	}
}
