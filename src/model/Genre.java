package model;

/**
 * This enum represents the genre of a book.
 */
public enum Genre {
	/**
	 * This literal represents the genre sciencie fiction of a book.
	 */
	SCIENCE_FICTION("Science Fiction"),
	/**
	 * This literal represents the genre fantasy of a book.
	 */
	FANTASY("Fantasy"),
	/**
	 * This literal represents the genre historical novel of a book.
	 */
	HISTORICAL_NOVEL("Historical Novel");

	/**
	 * This attribute represents the name of the genre.
	 */
	private final String name;

	/**
	 * This constructor initializes the genre with a given name.
	 */
	private Genre(String name) {
		this.name = name;
	}

	/**
	 * This function returns the name of the genre.
	 */
	public String getName() {
		return this.name;
	}
}