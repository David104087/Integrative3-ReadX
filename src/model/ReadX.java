package model;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			if (products.get(i) instanceof Magazine) {
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
	 * @param newStaus
	 * @param url
	 * @param price
	 * @param id
	 * @param review
	 * @param genre
	 */
	public String registerBook(String name, int pages, Calendar newStaus, String url, double price, String review, int genre) {
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

		BibliographicProduct book = new Book(name, pages, newStaus, url, price, review, bookGenre);

		products.add(book);

		msg += "\nBook information: " + book.toString();

		return msg;
	}

	/**
	 * 
	 * @param name
	 * @param pages
	 * @param newStaus
	 * @param url
	 * @param price
	 * @param preiodicity
	 * @param id
	 * @param category
	 */
	public String registerMagazine(String name, int pages, Calendar newStaus, String url, double price, String preiodicity, int category) {
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

		BibliographicProduct magazine = new Magazine(name, pages, newStaus, url, price, preiodicity, magazineCategory);

		products.add(magazine);

		msg += "\nMagazine information: " + magazine.toString();


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
		String msg = "";
		
		switch(dataToModify) {
			case 1:
				findProductById(productId).setName(newStaus);
				msg = "Name modified successfully!!!";
				break;
			case 2:
				findProductById(productId).setPages(Integer.parseInt(newStaus));//convert the string to integer
				msg = "Pages modified successfully!!!";
				break;
			case 3:
				Pattern regexDate = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");//regular expression to verify the date format dd/mm/yyyy
				Calendar newDatePublication = Calendar.getInstance();//create a new calendar to store the new date
				Matcher matcher = regexDate.matcher(newStaus);//match the date with the regular expression

				if (matcher.matches()) {//if the date matches the regular expression
					try {
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						dateFormat.setLenient(false);//not accept invalid dates like 31/02/2021
						newDatePublication.setTime(dateFormat.parse(newStaus));//convert the string to date and set the new date
						findProductById(productId).setPublicationDate(newDatePublication);//set the new date to the product
						msg = "Publication date modified successfully!!!";
					} catch (Exception e) {//catch the exception if the date is invalid
						msg = "Invalid date";
					}
				} else {
					msg ="Invalid date format";
				}
				break;
			case 4:
				findProductById(productId).setUrl(newStaus);
				msg = "URL modified successfully!!!";
				break;
			case 5:
				findProductById(productId).setPrice(Double.parseDouble(newStaus));
				msg = "Price modified successfully!!!";
				break;
			case 6:
				if (findProductById(productId) instanceof Book) {
					( (Book)findProductById(productId) ).setReview(newStaus);	
					msg = "Review modified successfully!!!";
				} else {
					( (Magazine)findProductById(productId) ).setPeriodicity(newStaus);
					msg = "Periodicity modified successfully!!!";
				}
				break;
			case 7:
				if (findProductById(productId) instanceof Book) {
					( (Book)findProductById(productId) ).setGenre(Genre.valueOf(newStaus));//valueOf convert the string to enum
					msg = "Genre modified successfully!!!";
				} else {
					( (Magazine)findProductById(productId) ).setCategory(Category.valueOf(newStaus));
					msg = "Category modified successfully!!!";
				}
				break;
			default:
				msg = "Invalid option";
				break;
		}

		return msg;
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