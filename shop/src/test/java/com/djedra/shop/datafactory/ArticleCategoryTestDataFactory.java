package com.djedra.shop.datafactory;

import com.djedra.shop.entity.ArticleCategory;

public class ArticleCategoryTestDataFactory {

	public static ArticleCategory getArticleCategory(String category) {
		ArticleCategory articleCategory = new ArticleCategory();
		articleCategory.setCategory(category);
		return articleCategory;
	}
}
