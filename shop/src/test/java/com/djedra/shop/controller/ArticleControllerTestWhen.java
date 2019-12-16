package com.djedra.shop.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.djedra.shop.components.jsonmergepatch.mapper.ArticleMapper;
import com.djedra.shop.components.jsonmergepatch.util.PatchHelper;
import com.djedra.shop.datafactory.ArticleCategoryTestDataFactory;
import com.djedra.shop.datafactory.ArticleTestDataFactory;
import com.djedra.shop.datafactory.StorageTestDataFactory;
import com.djedra.shop.datafactory.WarrantyTestDataFactory;
import com.djedra.shop.entity.Article;
import com.djedra.shop.facade.ArticleFacade;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ArticleController.class)
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ArticleControllerTestWhen {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatchHelper patchHelper;

	@MockBean
	private ArticleMapper articleMapper;

	@MockBean
	private ArticleFacade ArticleFacade;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	private void init() {
		List<Article> asList = Arrays.asList(ArticleTestDataFactory.getArticle(
				ArticleCategoryTestDataFactory.getArticleCategory("cat1"), StorageTestDataFactory.getStorage("stor1"),
				WarrantyTestDataFactory.getStorage("desc", LocalDate.now(), LocalDate.now().plusYears(2)), 1.1,
				"art1"));
		when(ArticleFacade.findAll()).thenReturn(asList);
	}

	@Test
	public void getArticles() throws Exception {

		String contentAsString = this.mockMvc.perform(get("/article")).andDo(print()).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		List<Article> articles = objectMapper.readValue(contentAsString, new TypeReference<List<Article>>() {
		});

		int a = 0;

	}

}
