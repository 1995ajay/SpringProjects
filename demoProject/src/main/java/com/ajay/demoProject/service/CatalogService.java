package com.ajay.demoProject.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ajay.demoProject.bean.CatalogDataResponse;
import com.ajay.demoProject.bean.CatalogSaveResponse;
import com.ajay.demoProject.dao.CatalogRepository;
import com.ajay.demoProject.entity.CatalogBean;

@Service
public class CatalogService {

	@Autowired
	CatalogRepository catRepository;

	public ResponseEntity<CatalogSaveResponse> saveCatalog(CatalogBean bean) {

		ResponseEntity<CatalogSaveResponse> caEntity;
		CatalogSaveResponse catalogResponse = new CatalogSaveResponse();
		CatalogBean savedBean = catRepository.save(bean);

		if (savedBean != null) {
			catalogResponse.setId(savedBean.getId());
			catalogResponse.setMessage("Success");
			caEntity = new ResponseEntity<CatalogSaveResponse>(catalogResponse, HttpStatus.CREATED);
		} else {
			catalogResponse.setId(bean.getId());
			catalogResponse.setMessage("Failure");
			caEntity = new ResponseEntity<CatalogSaveResponse>(catalogResponse, HttpStatus.BAD_REQUEST);
		}

		return caEntity;
	}

	public ResponseEntity<CatalogDataResponse> fetchCatalog(String sortOrder) {
		CatalogDataResponse catalogDataResponse = new CatalogDataResponse();
		List<CatalogBean> catalogBeans = new ArrayList<>();
		List<CatalogBean> sortedCatalogBeans;
		catRepository.findAll().forEach(item -> catalogBeans.add(item));
		Comparator<CatalogBean> comparator = (c1, c2) -> c1.getPrice().compareTo(c2.getPrice());
		
		if("asc".equals(sortOrder)) {
			comparator = (c1, c2) -> c1.getPrice().compareTo(c2.getPrice())*(-1);
		}
		
		sortedCatalogBeans = catalogBeans.stream().sorted(comparator)
							.collect(Collectors.toList());
		catalogDataResponse.setCatalogs(sortedCatalogBeans);

		return new ResponseEntity<CatalogDataResponse>(catalogDataResponse, HttpStatus.OK);
	}
	
	

	public CatalogBean fetchCatalogById(Integer id) {
		
		return catRepository.findById(id).orElseThrow(()-> new RuntimeException("Catalog not present for Id: "+id));
		
	}
	
}
