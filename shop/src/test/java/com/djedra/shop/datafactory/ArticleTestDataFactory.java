package com.djedra.shop.datafactory;

import com.djedra.shop.entity.Article;
import com.djedra.shop.entity.ArticleCategory;
import com.djedra.shop.entity.Storage;
import com.djedra.shop.entity.Warranty;

public class ArticleTestDataFactory {

//	public static Article getArticle(ArticleCategory articleCategory, Storage storage, double cost, String name) {
//		Article article = new Article();
//		article.setArticleCategory(articleCategory);
//		article.setStorage(storage);
//		article.setCost(cost);
//		article.setName(name);
//		return article;
//	}

	public static Article getArticle(ArticleCategory articleCategory, Storage storage, Warranty warranty, double cost,
			String name) {
		Article article = new Article();
		article.setArticleCategory(articleCategory);
		article.setStorage(storage);
		article.setWarranty(warranty);
		article.setCost(cost);
		article.setName(name);
		return article;
	}
}
