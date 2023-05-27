package model;
import java.util.Calendar;

/**
 * This class represents a book.
 */
public class Book extends BibliographicProduct {

	/**
	 * This attribute represents the review of the book.
	 */
	private String review;

	/**
	 * This attribute represents the genre of the book.
	 */
	private Genre genre;


	public Book(String name, int pages, Calendar publicationDate, String url, double price, String review, Genre genre) {
		super(name, pages, publicationDate, url, price);
		this.review = review;
		this.genre = genre;
	}

	/**
	 * The function generates a random 3-character hexadecimal ID.
	 * 
	 * @return A string containing a randomly generated hexadecimal ID with three characters.
	 */
	@Override
	public String generateId() {
		String hexadecimal = "ABCDEF0123456789";
		String hexId = "";
		for (int i = 0; i < 3; i++) {
			hexId += hexadecimal.charAt((int) (Math.random() * hexadecimal.length()));//generate a random character and add it to the id
		}
		return hexId;
	}

	/**
	 * The function returns a string that shows the attributes to modify for a book object, including
	 * review and genre options.
	 * 
	 * @return A string that includes the attributes to modify for a book object, including the review and
	 * genre, as well as options for other genres to choose from.
	 */
	@Override
	public String showAttributesToModify() {
		return super.showAttributesToModify() + "\n(6) Review: " + this.review + "\n" 
		+ "(7) Genre: " + this.genre.getName() + "\n" + "   Other genres:" + "\n    (1) Sciencie Fiction \n    (2) Fantasy \n    (3) Historical Novel";
	}

	/**
	 * This function overrides the default toString method to include the review, genre name, and ID of an
	 * object.
	 * 
	 * @return A string representation of an object, which includes the object's superclass's string
	 * representation, the review, the genre's name, and the object's ID.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nReview: " + this.review + "\n" +"Genre: " + this.genre.getName()
		+ "\n";
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}