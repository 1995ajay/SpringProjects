package com.ajay.demoProject.bean;

import java.util.List;

import com.ajay.demoProject.entity.CatalogBean;

public class CatalogDataResponse {
	
	List<CatalogBean> catalogs;

	public List<CatalogBean> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<CatalogBean> catalogs) {
		this.catalogs = catalogs;
	}

}
