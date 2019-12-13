package com.djedra.shop.controller;

import java.util.List;
import java.util.Optional;

import javax.json.JsonMergePatch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.djedra.shop.components.jsonmergepatch.PatchMediaType;
import com.djedra.shop.components.jsonmergepatch.mapper.ArticleMapper;
import com.djedra.shop.components.jsonmergepatch.resource.imput.ArticleResourceInput;
import com.djedra.shop.components.jsonmergepatch.util.PatchHelper;
import com.djedra.shop.entity.Article;
import com.djedra.shop.exception.ResourceNotFoundException;
import com.djedra.shop.facade.ArticleFacade;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/article")
@CrossOrigin
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleFacade articleFacade;

	private final PatchHelper patchHelper;

	private final ArticleMapper articleMapper;

	@GetMapping()
	public List<Article> get() throws Exception {
		return articleFacade.findAll();
	}

	@GetMapping("/{articleId}")
	public Optional<Article> getById(@PathVariable Long articleId) throws Exception {
		return articleFacade.findById(articleId);
	}

	@PostMapping()
	public Article add(@RequestBody Article article) {
		return articleFacade.save(article);
	}

	@DeleteMapping
	public void delete(@PathVariable Long articleId) {
		articleFacade.delete(articleId);
	}

	@GetMapping("/get-by-category")
	public Page<Article> getByCategory(@RequestParam(value = "articleCategory") String category, Pageable pageable)
			throws Exception {
		return articleFacade.findByCategory(category, pageable);
	}

	@GetMapping("/get-by-storage")
	public Page<Article> getByStorage(@RequestParam(value = "storageName") String storageName, Pageable pageable)
			throws Exception {
		return articleFacade.findByStorage(storageName, pageable);
	}

	@PatchMapping(path = "/{id}", consumes = PatchMediaType.APPLICATION_MERGE_PATCH_VALUE)
	public ResponseEntity<Void> updateContact(@PathVariable Long id, @RequestBody JsonMergePatch mergePatchDocument)
			throws Exception {

		Article article = articleFacade.findById(id).orElseThrow(ResourceNotFoundException::new);
		ArticleResourceInput articleResource = articleMapper.asInput(article);
		ArticleResourceInput articleResourcePatched = patchHelper.mergePatch(mergePatchDocument, articleResource,
				ArticleResourceInput.class);

		articleMapper.update(article, articleResourcePatched);
		articleFacade.save(article);

		return ResponseEntity.noContent().build();
	}
}
