package model;
import java.util.ArrayList;

public class Library {

	public static final int MAX_ROWS = 6;
	public  static final int MAX_COLUMNS = 6;
	private ArrayList<BibliographicProduct> products;
	private ArrayList<String[][]> shelfs;//va a contener los ids de todos los productos
	private ArrayList<ReadingSession> readingSessions;
	private int currentShelf;



    public Library() {
		products = new ArrayList<BibliographicProduct>();
    	shelfs = new ArrayList<String[][]>();
		readingSessions = new ArrayList<ReadingSession>();
		currentShelf = 0;
    }
	
	public ArrayList<BibliographicProduct> getProducts() {
		return products;
	}
    

	public void initShel(String[][] shelf) {

		for (int i = 1; i < MAX_COLUMNS; i++) {
			shelf[0][i] = "  " + String.valueOf(i-1) + "  |";//valueOf convierte un int a String
			shelf[i][0] = String.valueOf(i-1) + " |";
		}

		shelf[0][0] = "   ";

		for (int i = 1; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				if (shelf[i][j] == null) {
					shelf[i][j] = " ___ |";
				}
			}
		}

	}


	public String showShelf() {
		String content = "";

		String[][] shelf = shelfs.get(currentShelf);

		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				content += shelf[i][j];
			}
			content += "\n";
		}

		return content;
	}


	/**
	 * @param product
	 */
	public void addProduct(BibliographicProduct product) {
		products.add(product);

		sortProductsByAscendingDate();

		ReadingSession readingSession = new ReadingSession(product.getId());
		readingSessions.add(readingSession);

		shelfs.clear();
		boolean added = false;
		int index = 0;

		while (added == false) {
			for (int i = 0; i < shelfs.size(); i++) {
				String[][] shelf = shelfs.get(i);
				for (int j = 0; j < MAX_ROWS; j++) {
					for (int k = 0; k < MAX_COLUMNS; k++) {
						if (shelf[j][k].equals(" ___ |") && added == false) {
							shelf[j][k] = " " + products.get(index).getId() + " |";
							if (index == products.size() - 1) {
								added = true;
							}
							index++;
						}
					}
				}
			} 
			if (added == false) {
				String[][] shelf1 = new String[MAX_ROWS][MAX_COLUMNS];
				initShel(shelf1);
				shelfs.add(shelf1);
			}

		}

	}

	public void sortProductsByAscendingDate() {

		for (int i = 0; i < products.size(); i++) {
			int minIndex = i;

			for (int j = i + 1; j < products.size(); j++) {// j = i + 1 porque i ya esta ordenado
				if (products.get(j).getPublicationDate().compareTo(products.get(minIndex).getPublicationDate()) < 0) {
					minIndex = j;
				}
			}

			// Product swap, exchanges the product on the right (j, the one smaller than i) with the one on the left (i)
			BibliographicProduct temp = products.get(minIndex); // Temporarily stores the product at minIndex in a temporary variable called "temp"

			products.set(minIndex, products.get(i)); // Places the product at position i in the minIndex(j) position to perform the swap

			products.set(i, temp); // Places the product stored in "temp" at position i to complete the swap

			
		}
	}

	public ReadingSession getReadingSession(String id) {
		ReadingSession readingSession = null;
		for (int i = 0; i < readingSessions.size(); i++) {
			if (readingSessions.get(i).getId().equals(id)) {
				readingSession = readingSessions.get(i);
			}
		}
		return readingSession;
	}

	public ArrayList<String[][]> getShelfs() {
		return shelfs;
	}
	
	public int getCurrentShelf() {
		return currentShelf;
	}

	public void setCurrentShelf(int currentShelf) {
		this.currentShelf = currentShelf;
	}

	public void updateCurrentShelf(int currentShelf) {
		this.currentShelf += currentShelf;
	}

	/**
	 * The function updates the library by sorting products by ascending date, initializing shelfs, and
	 * filling them with product IDs.
	 */
	public void updateLibrary() {
		sortProductsByAscendingDate();
		shelfs.clear();
		//init shelfs
		for (int i = 0; i < products.size(); i++) {
			String[][] shelf = new String[MAX_ROWS][MAX_COLUMNS];
			initShel(shelf);
			shelfs.add(shelf);
		}

		//fill shelfs
		int index = 0;
		for (int i = 0; i < shelfs.size(); i++) {
			String[][] shelf = shelfs.get(i);
			for (int j = 0; j < MAX_ROWS; j++) {
				for (int k = 0; k < MAX_COLUMNS; k++) {
					if (shelf[j][k].equals(" ___ |") && index < products.size()) {
						shelf[j][k] = " " + products.get(index).getId() + " |";
						index++;
					}
				}
			}
		} 
	}

	public String unsubscribeOfAMagazine(String magazineId) {
		String msg = "";
		BibliographicProduct product = findProductById(magazineId);

		if (product != null) {
			products.remove(product);
			msg = "The product has been removed from the library.";
			updateLibrary();
		} else {
			msg = "The product could not be found.";
		}
		
		return msg;
	}

	/**
	 * This function searches for a product by ID in the list of books and magazines and returns the
	 * matching product.
	 * 
	 * @param productId a String representing the ID of a product that needs to be found in a list of
	 * products.
	 * @return The method is returning a BibliographicProduct object, which is either a Book or a Magazine,
	 * depending on the ID provided as a parameter. If no product is found with the given ID, the method
	 * returns null.
	 */
	public BibliographicProduct findProductById(String productId) {
		for (int i = 0; i < products.size(); i++) {
			if ((products).get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getId().equals(productId)) {
					return products.get(i);
				}
			} else {
				if ( ( (Book) products.get(i) ).getId().equals(productId)) {
					return products.get(i);
				}
			} 
		}
		return null;
	}

}