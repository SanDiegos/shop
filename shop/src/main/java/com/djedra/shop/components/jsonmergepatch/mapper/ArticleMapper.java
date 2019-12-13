package com.djedra.shop.components.jsonmergepatch.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.djedra.shop.components.jsonmergepatch.resource.imput.ArticleResourceInput;
import com.djedra.shop.entity.Article;

@Component
public class ArticleMapper {

	public ArticleResourceInput asInput(Article article) {
		ArticleResourceInput input = new ArticleResourceInput();
		if (Objects.isNull(article)) {
			return input;
		}
		input.setCost(article.getCost());
		input.setName(article.getName());
		return input;

	}

	public void update(Article article, ArticleResourceInput resourceInput) {
		if (Objects.isNull(article) || Objects.isNull(resourceInput)) {
			return;
		}
		article.setCost(resourceInput.getCost());
		article.setName(resourceInput.getName());
	}
}
