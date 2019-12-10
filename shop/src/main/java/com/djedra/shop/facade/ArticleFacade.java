package com.djedra.shop.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.djedra.shop.entity.Article;
import com.djedra.shop.reporitory.ArticleRepository;

@Component
//@AllArgsConstructor
public class ArticleFacade {

	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	public Optional<Article> findById(Long articleId) throws Exception {
		return articleRepository.findById(articleId);
	}

	public Article save(Article article) {
		return articleRepository.save(article);
	}

	public void delete(Long articleId) {
		articleRepository.deleteById(articleId);
	}

	public Page<Article> findByCategory(String category, Pageable pageable) {
		return articleRepository.findByArticleCategory_Category(category, pageable);
	}

	public Page<Article> findByStorage(String storageName, Pageable pageable) {
		return articleRepository.findByStorage_Name(storageName, pageable);
	}

}
