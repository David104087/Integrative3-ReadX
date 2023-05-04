package model;

public enum Category {
	VARITIES("Varities"),
	DESING("Desing"),
	SCIENTIFIC("Scientific");

	private final String name;

	private Category(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}