package model;
import java.util.ArrayList;

/**
 * This class represents a library that contains a collection of bibliographic products. The library
 * has a collection of shelves that contain the products. The library also has a collection of reading
 * sessions that contain the products that have been read.
 */
public class Library {

	/**
	 * This constant represents the maximum number of rows in a shelf.
	 */
	public static final int MAX_ROWS = 6;
	/**
	 * This constant represents the maximum number of columns in a shelf.
	 */
	public  static final int MAX_COLUMNS = 6;
	/**
	 * This attribute represents the products of the library.
	 */
	private ArrayList<BibliographicProduct> products;
	/**
	 * This attribute represents the shelfs of the library.
	 */
	private ArrayList<String[][]> shelfs;
	/**
	 * This attribute represents the reading sessions of the library.
	 */
	private ArrayList<ReadingSession> readingSessions;
	/**
	 * This attribute represents the current shelf of the library.
	 */
	private int currentShelf;



    public Library() {
		products = new ArrayList<BibliographicProduct>();
    	shelfs = new ArrayList<String[][]>();
		readingSessions = new ArrayList<ReadingSession>();
		currentShelf = 0;
    }

    

	/**
	 * The function initializes the matrix representing a shelf with row and column labels and empty
	 * spaces.
	 * 
	 * @param shelf a matrix representing the shelves in a store
	 */
	public void initShel(String[][] shelf) {

		for (int i = 1; i < MAX_COLUMNS; i++) {
			shelf[0][i] = "  " + String.valueOf(i-1) + "  |";//valueOf convert int to String
			shelf[i][0] = String.valueOf(i-1) + " |";
		}

		shelf[0][0] = "Y/X";

		for (int i = 1; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				if (shelf[i][j] == null) {
					shelf[i][j] = " ___ |";
				}
			}
		}

	}


	/**
	 * This function returns a string representation of the contents of a shelf.
	 * 
	 * @return returns a String that represents the content of the current shelf
	 * in the form of a matrix of strings.
	 */
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
	 * The function adds a bibliographic product to the list, sorts the list by date, creates a reading
	 * session for the product, and adds the product to a shelf in the library.
	 * 
	 * @param product a BibliographicProduct object that represents the product being added to the
	 * library's collection.
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

	/**
	 * This function sorts a list of bibliographic products by their publication date in ascending order.
	 */
	public void sortProductsByAscendingDate() {

		for (int i = 0; i < products.size(); i++) {
			int minIndex = i;

			for (int j = i + 1; j < products.size(); j++) {// j = i + 1 because the minimum index is always the one on the right (j)
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

	
	/**
	 * This function updates the library by removing a product, sorting the remaining products by date,
	 * initializing and filling the shelves with the updated products.
	 * 
	 * @param productId The ID of the product that needs to be updated in the library.
	 */
	public void updateLibrary(String productId) {

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId().equals(productId)) {
				products.remove(i);
			}
		}

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
						if (products.get(index) != null) {
							shelf[j][k] = " " + products.get(index).getId() + " |";
						} else {
							shelf[j][k] = " ___ |";
						}
						index++;
					}
				}
			}
		} 
	}

	/**
	 * This function removes a magazine from the library and updates the library accordingly, returning a
	 * message indicating success or failure. The method removes the magazine from the library's list of products and updates
	 * the library accordingly. The method returns a message indicating whether the operation was
	 * successful or not.
	 * 
	 * @param magazineId a String representing the unique identifier of a magazine that a user wants to
	 * unsubscribe from. 
	 * @return A String message indicating whether the magazine was successfully unsubscribed or not.
	 */
	public String unsubscribeOfAMagazine(String magazineId) {
		String msg = "";
		BibliographicProduct product = findProductById(magazineId);

		if (product != null) {
			products.remove(product);
			msg = "The product has been removed from the library.";
			updateLibrary(magazineId);
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
		BibliographicProduct product = null;
		for (int i = 0; i < products.size(); i++) {
			if ((products).get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getId().equals(productId)) {
					product = products.get(i);
				}
			} else {
				if ( ( (Book) products.get(i) ).getId().equals(productId)) {
					product = products.get(i);
				}
			} 
		}
		return product;
	}

	/**
	 * This function retrieves a ReadingSession object from the list of ReadingSession objects based on
	 * a given ID. The method searches for a ReadingSession object in a list of ReadingSession objects by
	 * comparing the id of each ReadingSession object with the given id parameter. If a match is found, the
	 * method returns the corresponding
	 * 
	 * @param id The parameter "id" is a String that represents the unique identifier of a ReadingSession
	 * object. 
	 * @return The method is returning a ReadingSession object with the specified id. If no ReadingSession
	 * object with the specified id is found in the readingSessions list, the method will return null.
	 */
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
	
	public ArrayList<BibliographicProduct> getProducts() {
		return products;
	}

}