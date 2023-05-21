package model;
import java.util.ArrayList;

public class Library {

	public static final int MAX_ROWS = 6;
	public  static final int MAX_COLUMNS = 6;
	private ArrayList<BibliographicProduct> products;
	private ArrayList<String[][]> library;//va a contener los ids de todos los productos

    public Library() {
		products = new ArrayList<BibliographicProduct>();
    	library = new ArrayList<String[][]>();
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

	// public void updateLibrary() {
	// 	String[][] shelf = new String[MAX_ROWS][MAX_COLUMNS];
	// 	int shelfRow = 1;
	// 	int shelfColumn = 1;
	// 	initShel(shelf);//inicializa la estanteria
	// 	for (int i = 0; i < products.size(); i++) {//recorre la lista de productos
	// 		shelf[shelfRow][shelfColumn] = " " + (products.get(i)).getId() + " |";// agrega el id del producto a la estanteria
	// 		shelfColumn++;//aumenta la columna para agregar el siguiente producto
	// 		if (shelfColumn == MAX_COLUMNS) {//si la columna es igual al maximo de columnas significa que ya no hay mas espacio en la fila
	// 			shelfColumn = 1;//entonces inicializamos la columna en 0 de nuevo
	// 			shelfRow++;//avanzamos a la siguiente fila
	// 		}
	// 		if (shelfRow == MAX_ROWS) {//si la fila es igual al maximo de filas significa que ya no hay mas espacio en la estanteria y se pasa a la siguiente estanteria
	// 			library.add(shelf);//agrega la estanteria a la biblioteca
	// 			shelf = new String[MAX_ROWS][MAX_COLUMNS];//crea una nueva estanteria
	// 			initShel(shelf);//inicializa la nueva estanteria
	// 			//reinicia los indices de la estanteria
	// 			shelfRow = 1;
	// 			shelfColumn = 1;
	// 		}
	// 	}
	// 	library.add(shelf);//agrega la ultima estanteria a la biblioteca
	// }


	public String showFirstShel() {
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
		sortProductsByAscendingDate(products);

		boolean added = false;
		for (int i = 0; i < library.size(); i++) {
			String[][] shelf = library.get(i);
			for (int j = 0; j < MAX_ROWS; j++) {
				for (int k = 0; k < MAX_COLUMNS; k++) {
					if (shelf[j][k].equals(" ___ |") && !added) {
						shelf[j][k] = " " + product.getId() + " |";
						added = true;
					}
				}
			}
		} 
		if (!added) {
			String[][] shelf = new String[MAX_ROWS][MAX_COLUMNS];
			initShel(shelf);
			shelf[1][1] = " " + product.getId() + " |";
			library.add(shelf);
		}

		sortLibraryProductsByAscendingDate(library);

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

		System.out.println(msg);

	}

	public void sortLibraryProductsByAscendingDate( ArrayList<String[][]> library) {
		
		for (int i = 0; i < library.size(); i++) {
			int minIndex = i; // Stores the index of the smallest product

			for (int j = i + 1; j < library.size(); j++) {// j = i + 1 porque i ya esta ordenado

				String product1Id = library.get(j)[1][1].substring(1, 4);
				BibliographicProduct product1 = findProductById(product1Id);

				String product2Id = library.get(minIndex)[1][1].substring(1, 4);
				BibliographicProduct product2 = findProductById(product2Id);

				if (product1.getPublicationDate().compareTo(product2.getPublicationDate()) < 0) {
					minIndex = j;
				}

			}

			// Product swap, exchanges the product on the right (j, the one smaller than i) with the one on the left (i)
			String[][] temp = library.get(minIndex); // Temporarily stores the product at minIndex in a temporary variable called "temp"

			library.set(minIndex, library.get(i)); // Places the product at position i in the minIndex(j) position to perform the swap

			library.set(i, temp); // Places the product stored in "temp" at position i to complete the swap

		}
	}

	public void sortProductsByAscendingDate(ArrayList<BibliographicProduct> products) {

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

	public BibliographicProduct findProductById(String id) {
		BibliographicProduct product = null;
		boolean found = false;
		int i = 0;
		while (i < products.size() && !found) {
			if (products.get(i).getId().equals(id)) {
				product = products.get(i);
				found = true;
			}
			i++;
		}
		return product;
	}
	

}