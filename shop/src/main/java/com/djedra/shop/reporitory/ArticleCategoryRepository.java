package com.djedra.shop.reporitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.djedra.shop.entity.ArticleCategory;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Long> {

	Optional<ArticleCategory> findByCategory(String category);

}
