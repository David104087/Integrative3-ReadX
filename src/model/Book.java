package model;
import java.util.Calendar;

public class Book extends BibliographicProduct {

	private String review;
	private int unitsSold;
	private Genre genre;

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

	public Genre getGenre() {
		return this.genre;
	}

	/**
	 * 
	 * @param genre
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString() + "Genre: " + genre.getName() + "\n";
	}

}