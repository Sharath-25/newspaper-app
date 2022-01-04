package com.xworkz.newspaper.dto;

public class NewsPaperDTO {

	private String newsPaperName;
	private double price;
	private String langauge;
	private int noOfPages;

	public NewsPaperDTO() {

	}

	public NewsPaperDTO(String newsPaperName, double price, String langauge, int noOfPages) {
		this.newsPaperName = newsPaperName;
		this.price = price;
		this.langauge = langauge;
		this.noOfPages = noOfPages;
	}

	public String getNewsPaperName() {
		return newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLangauge() {
		return langauge;
	}

	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	@Override
	public String toString() {
		return "NewsPaper [newsPaperName=" + newsPaperName + ", price=" + price + ", langauge=" + langauge
				+ ", noOfPages=" + noOfPages + "]";
	}

}
