package com.ajay.demoProject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajay.demoProject.entity.CatalogBean;

@Repository
public interface CatalogRepository extends CrudRepository<CatalogBean, Integer> {

}
