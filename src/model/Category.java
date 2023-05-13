package model;

/**
 * This enum represents the category of a magazine.
 */
public enum Category {
	/**
	 * This literal represents the category varities of a magazine.
	 */
	VARITIES("Varities"),
	/**
	 * This literal represents the category desing of a magazine.
	 */
	DESING("Desing"),
	/**
	 * This literal represents the category scientific of a magazine.
	 */
	SCIENTIFIC("Scientific");

	/**
	 * This attribute represents the name of the category.
	 */
	private final String name;

	/**
	 * This constructor initializes the category with a given name.
	 */
	private Category(String name) {
		this.name = name;
	}

	/**
	 * This function returns the name of the category.
	 */
	public String getName() {
		return this.name;
	}
}