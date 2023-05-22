package model;
import java.util.ArrayList;

public class Library {

	public static final int MAX_ROWS = 6;
	public  static final int MAX_COLUMNS = 6;
	private ArrayList<BibliographicProduct> products;
	private ArrayList<String[][]> library;//va a contener los ids de todos los productos
	private ArrayList<ReadingSession> readingSessions;


    public Library() {
		products = new ArrayList<BibliographicProduct>();
    	library = new ArrayList<String[][]>();
		readingSessions = new ArrayList<ReadingSession>();
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

	public String showLibrary() {
		String msg = "";

		for (int i = 0; i < library.size(); i++) {
			String[][] shelf = library.get(i);
			for (int j = 0; j < MAX_ROWS; j++) {
				for (int k = 0; k < MAX_COLUMNS; k++) {
					msg += shelf[j][k];
				}
				msg += "\n";
			}
			msg += "\n";
		}

		return msg;
	}


	/**
	 * @param product
	 */
	public void addProduct(BibliographicProduct product) {
		products.add(product);

		sortProductsByAscendingDate();

		ReadingSession readingSession = new ReadingSession(product.getId());
		readingSessions.add(readingSession);

		library.clear();
		boolean added = false;
		int index = 0;

		while (added == false) {
			for (int i = 0; i < library.size(); i++) {
				String[][] shelf = library.get(i);
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
				library.add(shelf1);
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
		for (int i = 0; i < readingSessions.size(); i++) {
			if (readingSessions.get(i).getId().equals(id)) {
				return readingSessions.get(i);
			}
		}
		return null;
	}
	

}