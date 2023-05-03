package model;

public class Book extends BibliographicProduct {

	private String review;
	private int unitsSold;

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param publicationDate
	 * @param url
	 * @param price
	 * @param id
	 * @param review
	 * @param genre
	 */
	public Book(String name, int pages, Calendar publicationDate, String url, double price, String id, String review, Genre genre) {
		super(name, pages, publicationDate, url, price, id);
		this.review = review;
		this.genre = genre;
	}

	public String getReview() {
		return this.review;
	}

	/**
	 * 
	 * @param review
	 */
	public void setReview(String review) {
		this.review = review;
	}

	public int getUnitsSold() {
		return this.unitsSold;
	}

	/**
	 * 
	 * @param unitsSold
	 */
	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

}