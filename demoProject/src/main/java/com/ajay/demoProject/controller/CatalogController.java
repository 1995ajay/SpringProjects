package com.ajay.demoProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.demoProject.bean.CatalogDataResponse;
import com.ajay.demoProject.bean.CatalogSaveResponse;
import com.ajay.demoProject.entity.CatalogBean;
import com.ajay.demoProject.service.CatalogService;

@RestController
public class CatalogController {

	@Autowired
	CatalogService catService;

	@PostMapping(value = "catalog")
	public ResponseEntity<CatalogSaveResponse> saveCatalog(@RequestBody CatalogBean catalogueBean) {

		ResponseEntity<CatalogSaveResponse> response = catService.saveCatalog(catalogueBean);

		return response;
	}
	
	@GetMapping(value="catalog")
	public ResponseEntity<CatalogDataResponse> getCatalogs(@RequestParam(defaultValue = "dsc") String sortOrder){
		
		return catService.fetchCatalog(sortOrder);
	}

}
