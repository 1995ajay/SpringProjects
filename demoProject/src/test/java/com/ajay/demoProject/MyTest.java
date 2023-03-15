package com.ajay.demoProject;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ajay.demoProject.dao.CatalogRepository;
import com.ajay.demoProject.entity.CatalogBean;

@DataJpaTest
class MyTest {
	
	@Autowired
	CatalogRepository catalogueRepository;

	@Test
	void testCatalogService_fetchCatalog() {
		
		List<CatalogBean> beans = new ArrayList<>();
				
		
		
		CatalogBean cb = catalogueRepository.save(new CatalogBean(1,"Ajay","this is ajay",10.0));
		
		assertNotNull(cb);
	
	}
	
	
	
	
	

}
