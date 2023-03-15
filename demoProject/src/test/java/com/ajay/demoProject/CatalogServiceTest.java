package com.ajay.demoProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.ajay.demoProject.bean.CatalogSaveResponse;
import com.ajay.demoProject.dao.CatalogRepository;
import com.ajay.demoProject.entity.CatalogBean;
import com.ajay.demoProject.service.CatalogService;

@ExtendWith(MockitoExtension.class)
class CatalogServiceTest {
	
	@InjectMocks
	CatalogService catalogService;
	
	@Mock
	CatalogRepository catalogRepository;
	

	@Test
	void testSave() {
		CatalogBean cb = new CatalogBean(1,"Ajay","this is ajay",10.0);
		
		when(catalogRepository.save(any(CatalogBean.class))).thenReturn(cb);
		
		ResponseEntity<CatalogSaveResponse> rscb = catalogService.saveCatalog(cb);
		
		assertNotNull(rscb.getBody());
		
	}
	
	@Test
	void testSave_f() {
		CatalogBean cb = new CatalogBean(1,"Ajay","this is ajay",10.0);
		
		when(catalogRepository.save(any(CatalogBean.class))).thenReturn(null);
		
		ResponseEntity<CatalogSaveResponse> rscb = catalogService.saveCatalog(cb);
		
		assertEquals("Failure",rscb.getBody().getMessage());
		
	}
	
	@Test
	void testFetch() {
		
		List<CatalogBean> catalogBeans = new ArrayList<>();
		catalogBeans.add(new CatalogBean(1,"Ajay","this is ajay",10.0));
		catalogBeans.add(new CatalogBean(2,"Ajay","this is ajay",10.0));
		
		when(catalogRepository.findAll()).thenReturn(catalogBeans);
		
		catalogService.fetchCatalog("asc");
		
		assertNotNull( catalogService.fetchCatalog("").getBody());
	}
	
	@Test
	void testFetchById() {
		
	
		CatalogBean cb =new CatalogBean(1,"Ajay","this is ajay",10.0);
		
		when(catalogRepository.findById(1)).thenReturn(Optional.of(cb));
		
		CatalogBean cbResult = catalogService.fetchCatalogById(1);
		
		assertNotNull( cbResult);
	}
	
	@Test
	void testFetchByIdException() {
		
	
		CatalogBean cb =new CatalogBean(1,"Ajay","this is ajay",10.0);
		
		when(catalogRepository.findById(1)).thenReturn(Optional.of(cb));
		
		assertThrows(RuntimeException.class, ()->catalogService.fetchCatalogById(2));
	}

}
