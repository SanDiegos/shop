package com.djedra.shop.datafactory;

import com.djedra.shop.entity.Article;
import com.djedra.shop.entity.ArticleCategory;
import com.djedra.shop.entity.Storage;

public class ArticleTestDataFactory {

	public static Article getArticle(ArticleCategory articleCategory, Storage storage, double cost, String name) {
		Article article = new Article();
		article.setArticleCategory(articleCategory);
		article.setStorage(storage);
		article.setCost(cost);
		article.setName(name);
		return article;
	}
}
