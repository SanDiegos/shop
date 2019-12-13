package com.djedra.shop.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.djedra.shop.datafactory.ArticleCategoryTestDataFactory;
import com.djedra.shop.datafactory.ArticleTestDataFactory;
import com.djedra.shop.datafactory.StorageTestDataFactory;
import com.djedra.shop.entity.Article;
import com.djedra.shop.entity.ArticleCategory;
import com.djedra.shop.entity.Storage;
import com.djedra.shop.reporitory.ArticleCategoryRepository;
import com.djedra.shop.reporitory.ArticleRepository;
import com.djedra.shop.reporitory.StorageRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(ArticleController.class)
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ArticleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticleCategoryRepository articleCategoryRepository;
	@Autowired
	private StorageRepository storageRepository;

	private Article existingArticle;
	private ArticleCategory existingArticleCategory;
	private Storage existingStorage;

	@BeforeAll
	private void init() {
		existingArticleCategory = articleCategoryRepository
				.save(ArticleCategoryTestDataFactory.getArticleCategory("cat1"));
		existingStorage = storageRepository.save(StorageTestDataFactory.getStorage("stor1"));
		existingArticle = articleRepository
				.save(ArticleTestDataFactory.getArticle(existingArticleCategory, existingStorage, 1.1, "art1"));
	}

	@Test
	public void getArticles() throws Exception {

		String contentAsString = this.mockMvc.perform(get("/article")).andDo(print()).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<Article> articles = objectMapper.readValue(contentAsString, new TypeReference<List<Article>>() {
		});

		assertAll(() -> {
			assertEquals(articles.size(), 1);
			assertEquals(articles.get(0).getArticleCategory(), existingArticleCategory);
		});

	}

}
