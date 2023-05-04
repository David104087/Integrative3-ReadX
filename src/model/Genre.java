package model;

public enum Genre {
	SCIENCIE_FICTION("Sciencie Fiction"),
	FANTASY("Fantasy"),
	HISTORICAL_NOVEL("Historycal Novel");//CORRGIR EN DIAGRAMA

	private final String name;

	private Genre(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}