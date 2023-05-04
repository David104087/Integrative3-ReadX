package model;
import java.util.Calendar;
import java.util.ArrayList;

public class ReadX {

	private ArrayList<User> users;
	private ArrayList<BibliographicProduct> products;

	/**
	 * This method is the constructor of the class ReadX
	 */
	public ReadX() {
		users = new ArrayList<User>();
		products = new ArrayList<BibliographicProduct>();
	}

	/**
	 * This Java function searches for a user in a list of users by their ID and returns the user object if
	 * found, otherwise it returns null.
	 * 
	 * @param userId The parameter "userId" is a String that represents the unique identifier of a user.
	 * The method "findUserById" searches for a user in a list of users by comparing their IDs with the
	 * given "userId" parameter. If a user with the matching ID is found, the method returns that user
	 * @return This method returns a User object with the specified userId if it exists in the users list,
	 * otherwise it returns null.
	 */
	public User findUserById(String userId) { 
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(userId)) {
				return users.get(i);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param productId
	 */
	public BibliographicProduct findProductById(String productId) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId().equals(productId)) {
				return products.get(i);
			}
		}
		return null;
	}
	

	/**
	 * 
	 * @param productName
	 */
	public BibliographicProduct findProductByName(String productName) {
		// TODO - implement ReadX.findProductByName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param id
	 * @param userTye
	 */
	public String registerUser(String name, String id, int userType) {
		String msg = "User registered successfully!!!";
		User user = null;
	
		if (userType == 1) {
			user = new PremiumUser(name, id, Calendar.getInstance());
		} else {
			user = new RegularUser(name, id, Calendar.getInstance());
		}
		users.add(user);
	
		return msg;
	}
	

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
	public String registerBook(String name, int pages, Calendar publicationDate, String url, double price, String id, String review, int genre) {
		String msg = "Book registered successfully!!!";
		Genre bookGenre = null;

		if ( genre == 1) {
			bookGenre = Genre.SCIENCIE_FICTION;
		} 
		else if (genre == 2) {
			bookGenre = Genre.FANTASY;
		} 
		else {
			bookGenre = Genre.HISTORICAL_NOVEL;
		}

		BibliographicProduct book = new Book(name, pages, publicationDate, url, price, id, review, bookGenre);

		products.add(book);

		return msg;
	}

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param publicationDate
	 * @param url
	 * @param price
	 * @param preiodicity
	 * @param id
	 * @param category
	 */
	public String registerMagazine(String name, int pages, Calendar publicationDate, String url, double price, String preiodicity, String id, int category) {
		String msg = "Magazine registered successfully!!!";
		Category magazineCategory  = null;


		if ( category == 1) {
			magazineCategory = Category.VARITIES;
		} 
		else if (category == 2) {
			magazineCategory = Category.DESING;
		} 
		else {
			magazineCategory = Category.SCIENTIFIC;
		}

		BibliographicProduct magazine = new Magazine(name, pages, publicationDate, url, price, id, preiodicity, magazineCategory);

		products.add(magazine);

		return msg;
	}

	public void initReadX() {
		// TODO - implement ReadX.initReadX
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param productId
	 * @param dataToModify
	 * @param newStaus
	 */
	public String modifyProduct(String productId, int dataToModify, String newStaus) {
		// TODO - implement ReadX.modifyProduct
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param productId
	 */
	public String deleteProduct(String productId) {
		// TODO - implement ReadX.deleteProduct
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param bookName
	 */
	public String buyBook(String userId, String bookName) {
		// TODO - implement ReadX.buyBook
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param magazineName
	 */
	public String suscribeToAMagazine(String userId, String magazineName) {
		// TODO - implement ReadX.suscribeToAMagazine
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 * @param magazineName
	 */
	public String unsuscribeOfAMagazine(String userId, int magazineName) {
		// TODO - implement ReadX.unsuscribeOfAMagazine
		throw new UnsupportedOperationException();
	}

	public void displayAdvertising() {
		// TODO - implement ReadX.displayAdvertising
		throw new UnsupportedOperationException();
	}

	public String readingSession() {
		// TODO - implement ReadX.readingSession
		throw new UnsupportedOperationException();
	}

}