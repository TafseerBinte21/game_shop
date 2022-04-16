package com.tafa.GameShop.controllers.dto;

public class GameDto {

	private Long id;
	private String name;
	private String genre;
	private String description;
	private String price;
	private String image;

	public GameDto() {

	}

	public GameDto(Long id, String name, String genre, String description, String price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
