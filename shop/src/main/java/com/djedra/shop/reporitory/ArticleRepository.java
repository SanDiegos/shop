package com.djedra.shop.reporitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djedra.shop.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

//	wygląda na to, że tu chce nazwę tabeli z jakiej bierze a póziej pole tabeli po którym się szuka 
	Page<Article> findByArticleCategory_Category(String category, Pageable pageable);

	Page<Article> findByStorage_Name(String storageName, Pageable pageable);

}
