package com.xworkz.newspaper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "newsPaper_table")
@NamedQuery(name = "NewsPaperEntity.getnewsPaperObject", query = "from NewsPaperEntity where newsPaperName=:name")
public class NewsPaperEntity implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NEWSPAPER_ID")
	private int newsPaperID;

	@Column(name = "NEWSPAPERNAME")
	private String newsPaperName;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "LANGAUGE")
	private String langauge;

	@Column(name = "NO_OF_PAGES")
	private int noOfPages;

	public NewsPaperEntity() {
		super();
	}

	public NewsPaperEntity(int newsPaperID, String newsPaperName, double price, String langauge, int noOfPages) {
		super();
		this.newsPaperID = newsPaperID;
		this.newsPaperName = newsPaperName;
		this.price = price;
		this.langauge = langauge;
		this.noOfPages = noOfPages;
	}

	public int getNewsPaperID() {
		return newsPaperID;
	}

	public void setNewsPaperID(int newsPaperID) {
		this.newsPaperID = newsPaperID;
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
		return "NewsPaperEntity [newsPaperID=" + newsPaperID + ", newsPaperName=" + newsPaperName + ", price=" + price
				+ ", langauge=" + langauge + ", noOfPages=" + noOfPages + "]";
	}

}
