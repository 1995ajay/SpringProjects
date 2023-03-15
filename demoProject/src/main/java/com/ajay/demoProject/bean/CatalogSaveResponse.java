package com.ajay.demoProject.bean;

public class CatalogSaveResponse {

	private Integer id;
	private String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CatalogSaveResponse(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public CatalogSaveResponse() {
		super();
	}

	
}
