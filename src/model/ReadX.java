package model;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is the controller of the program, the conexion between the view and the model.
 */
public class ReadX {

	/**
	 * This attribute represents the list of users that are registered in the program
	 */
	private ArrayList<User> users;

	/**
	 * This attribute represents the list of products that are registered in the program
	 */
	private ArrayList<BibliographicProduct> products;

	public ReadX() {
		users = new ArrayList<User>();
		products = new ArrayList<BibliographicProduct>();
	}

	/**
	 * This function searches for a user in a list of users by their ID and returns the user object if
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
	 * This function searches for a product by its ID in the list of books and magazines and returns the
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
	 * This function searches for a product by name in the list of books and magazines and returns the
	 * matching product.
	 * 
	 * @param productName a String representing the name of a product to search for in a list of
	 * BibliographicProduct objects.
	 * @return The method is returning a BibliographicProduct object, which represents a book or a magazine
	 * with the specified name. If no product with the specified name is found, the method returns null.
	 */
	public BibliographicProduct findProductByName(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getName().equals(productName)) {
					return products.get(i);
				}
			} else {
				if ( ( (Book) products.get(i) ).getName().equals(productName)) {
					return products.get(i);
				}
			} 
		}
		return null;
	}

	/**
	 * The function registers a user with a given name, ID, balance, and user type, and returns a message
	 * indicating the success of the registration and the user's information.
	 * 
	 * @param name The name of the user being registered.
	 * @param id The ID of the user being registered.
	 * @param balance The initial balance of the user's account.
	 * @param userType an integer value representing the type of user being registered. A value of 1
	 * represents a PremiumUser and a value of 2 represents a RegularUser.
	 * @return The method `registerUser` returns a `String` message indicating whether the user was
	 * registered successfully or not, along with the user information such as user type, name, id,
	 * registration date, and balance.
	 */
	public String registerUser(String name, String id, double balance, int userType) {
		String msg = "User registered successfully!!!";
		User user = null;
	
		if (userType == 1) {
			user = new PremiumUser(name, id, Calendar.getInstance(), balance);
			msg += "\nUser information:" + "\n" + "User type: Premium\n";
		} else {
			user = new RegularUser(name, id, Calendar.getInstance(), balance);
			msg += "\nUser information:" + "\n" + "User type: Regular\n";
		}
		users.add(user);

		msg += user.toString() + "\n";
	
		return msg;
	}
	

	/**
	 * The function registers a book with its information and genre in the list of products.
	 * 
	 * @param name The name of the book being registered.
	 * @param pages The number of pages in the book.
	 * @param publicationDate A Calendar object representing the date of publication of the book.
	 * @param url The URL parameter is a String that represents the URL of the book's cover image.
	 * @param price The price of the book being registered.
	 * @param review The review parameter is a String that represents the review or critique of the book
	 * being registered.
	 * @param genre The genre parameter is an integer that represents the genre of the book being
	 * registered. It can have a value of 1, 2, or any other integer. The value 1 represents the science
	 * fiction genre, the value 2 represents the fantasy genre, and any other value represents the
	 * historical novel
	 * @return The method is returning a String message that indicates whether the book was registered
	 * successfully or not, and includes the book information if it was registered successfully.
	 */
	public String registerBook(String name, int pages, Calendar publicationDate, String url, double price, String review, int genre) {
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

		BibliographicProduct book = new Book(name, pages, publicationDate, url, price, review, bookGenre);

		products.add(book);

		msg += "\nBook information:\n " + book.toString();

		return msg;
	}

	/**
	 * The function registers a new magazine with its information and category and adds it to the list of
	 * products.
	 * 
	 * @param name The name of the magazine being registered (String).
	 * @param pages The number of pages in the magazine.
	 * @param publicationDate A Calendar object representing the date of publication of the magazine.
	 * @param url The URL parameter is a string that represents the URL of the magazine's cover image.
	 * @param price The price of the magazine.
	 * @param preiodicity The parameter "preiodicity" is likely a misspelling of "periodicity" and refers
	 * to how often the magazine is published (e.g. weekly, monthly, quarterly).
	 * @param category an integer representing the category of the magazine. 1 represents "VARITIES", 2
	 * represents "DESIGN", and any other integer represents "SCIENTIFIC".
	 * @return A message indicating that the magazine has been registered successfully, along with the
	 * information of the registered magazine.
	 */
	public String registerMagazine(String name, int pages, Calendar publicationDate, String url, double price, String preiodicity, int category) {
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

		BibliographicProduct magazine = new Magazine(name, pages, publicationDate, url, price, preiodicity, magazineCategory);

		products.add(magazine);

		msg += "\nMagazine information: " + magazine.toString();


		return msg;
	}

	/**
	 * The function initializes and registers users, books, and magazines, and returns a message containing
	 * the registered items.
	 * 
	 * @return The method `initReadX()` is returning a `String` message that contains information about
	 * registered users, books, and magazines.
	 */
	public String initReadX() {

		String msg = "";

		msg += "------------------\n"
				+ "Users:\n"
				+ "------------------\n";

		//register 1 premium user and 1 regular user
		for (int i = 1; i < 3; i++) {
			msg += "\n(" + (i) + ") " + registerUser("User" + i, "id" + i, 100.0, i);
		}

		msg += "\n------------------\n"
				+ "Books:\n"
				+ "------------------\n";

		//register 3 books by genre 
		for (int i = 1; i < 4; i++) {
			msg += "\n(" + (i) + ") " + registerBook("book" + i, 30, Calendar.getInstance(), "thing.jpg", 30.0, "Very good", i);
		}

		msg += "\n------------------\n"
				+ "Magazines:\n"
				+ "------------------\n";

		//register 3 magazines by category
		for (int i = 1; i < 4; i++) {
			msg += "\n(" + (i) + ") " + registerMagazine("magazine" + i, 25, Calendar.getInstance(), "thing1.jpg", 5.0, "Weekly", i);
		}

		return msg;
	}


	/**
	 * This function modifies a bibliographic product based on the data to modify and the new status
	 * provided.
	 * 
	 * @param productId a String representing the ID of the product to be modified.
	 * @param dataToModify an integer representing which data field of the product to modify (1 for name, 2
	 * for pages, 3 for publication date, 4 for URL, 5 for price, 6 for review/periodicity, 7 for
	 * genre/category)
	 * @param newStaus The new value to be set for the specified dataToModify parameter.
	 * @return The method is returning a String message indicating whether the modification was successful
	 * or not.
	 */
	public String modifyProduct(String productId, int dataToModify, String newStaus) {
		String msg = "";
		BibliographicProduct product = findProductById(productId);

		
		switch(dataToModify) {
			case 1:

				product.setName(newStaus);
				msg = "Name modified successfully!!!";
				break;

			case 2:

				product.setPages(Integer.parseInt(newStaus));//convert the string to integer
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
						product.setPublicationDate(newDatePublication);//set the new date to the product
						msg = "Publication date modified successfully!!!";
					} catch (Exception e) {//catch the exception if the date is invalid
						msg = "Invalid date";
					}
				} else {
					msg ="Invalid date format";
				}
				break;

			case 4:

				product.setUrl(newStaus);
				msg = "URL modified successfully!!!";
				break;

			case 5:

				product.setPrice(Double.parseDouble(newStaus));
				msg = "Price modified successfully!!!";
				break;

			case 6:

				if (product instanceof Book) {
					( (Book) product ).setReview(newStaus);	
					msg = "Review modified successfully!!!";
				} else {
					( (Magazine) product ).setPeriodicity(newStaus);
					msg = "Periodicity modified successfully!!!";
				}
				break;

			case 7:

				if (newStaus.equals("1") || newStaus.equals("2") || newStaus.equals("3")) {
					Genre bookGenre = null;
					Category magazineCategory = null;

					if (newStaus.equals("1" ) && product instanceof Book) {
						bookGenre = Genre.SCIENCIE_FICTION;
					} else if (newStaus.equals("1") && product instanceof Magazine){
						magazineCategory = Category.VARITIES;
					}
					if (newStaus.equals("2") && product instanceof Book) {
						bookGenre = Genre.FANTASY;
					} else if (newStaus.equals("2") && product instanceof Magazine){
						magazineCategory = Category.DESING;
					}
					if (newStaus.equals("3") && product instanceof Book){
						bookGenre = Genre.HISTORICAL_NOVEL;
					} else if (newStaus.equals("3") && product instanceof Magazine){
						magazineCategory = Category.SCIENTIFIC;
					}

					if (product instanceof Book) {
						( (Book) product ).setGenre(bookGenre);
						msg = "Genre modified successfully!!!";
					} else {
						( (Magazine) product ).setCategory(magazineCategory);
						msg = "Category modified successfully!!!";
					}

				} else {
					msg = "Invalid option";
				}


				break;
			default:
				msg = "Invalid option";
				break;
		}

		return msg;
	}

	/**
	 * This function deletes a bibliographic product from the products list based on the ID provided.
	 * 
	 * @param productId a String representing the ID of the product to be deleted.
	 * @return The method is returning a String message indicating whether the deletion was successful or
	 * not.
	 */
	public String deleteProduct(String productId) {
		String msg = "";
		boolean productFound = false;
	
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				if (((Magazine) products.get(i)).getId().equals(productId)) {
					products.remove(i);
					msg = "Magazine deleted successfully!!!";
					productFound = true;
					break;// get out of the loop after deleting the product
				}
			} else if (products.get(i) instanceof Book) {
				if (((Book) products.get(i)).getId().equals(productId)) {
					products.remove(i);
					msg = "Book deleted successfully!!!";
					productFound = true;
					break;
				}
			}
		}
	
		if (!productFound) {
			msg = "Product not found";
		}
	
		return msg;
	}
	
	/**
	 * The function allows a user to purchase a book if they have enough funds and have not already
	 * purchased 5 books (unless they are a premium user), and returns a message indicating the success or
	 * failure of the purchase.
	 * 
	 * @param userId A string representing the ID of the user who wants to buy the book.
	 * @param bookName The name of the book that the user wants to buy.
	 * @return The method is returning a message (String) indicating the result of the book purchase
	 * operation.
	 */
	public String buyBook(String userId, String bookName) {
		String msg = "";

		Book book = (Book) findProductByName(bookName);
		User user = findUserById(userId);

		if (book != null) {//if the book exists
			if (user != null) {//if the user exists
				if (user instanceof PremiumUser || ( (RegularUser)user ).getBooksPurchased() < 5) { //if the user is premium or regular and has not purchased 5 books
					if (user.getBalance() >= book.getPrice()) {//if the user has enough money

						Invoice invoice = new Invoice(book.getName(), book.getPrice(), Calendar.getInstance());//create a new invoice
						user.getLibrary().addProduct(book);//add the book to the user's library
						user.addInvocie(invoice);
						user.setBalance(user.getBalance() - book.getPrice());//subtract the price of the book to the user's balance
						msg = "Book " + book.getId() + " purchased successfully!!!" + "\n" + "Your new balance is: $ " + user.getBalance()
						+ "\n" + invoice.toString();
						book.setUnitsSold(1);

						if (user instanceof RegularUser) {
							( (RegularUser) user ).setBooksPurchased(1);
						}

					} else {
						msg = "Insufficient funds";
					}
				} else {
					msg = "\n You have already purchased 5 books, upgrade to premium to buy more books!!! \n";
				}

			} else {
				msg = "User not found";
			}
		} else {
			msg = "Book not found";
		}
		
		return msg;
	}


	/**
	 * The function allows a user to subscribe to a magazine if they have enough funds and have not already
	 * subscribed to a 2 magazines (unless they are a premium user), and returns a message indicating the success or
	 * failure of the subcription.
	 * 
	 * @param userId A string representing the ID of the user who wants to subscribe to a magazine.
	 * @param magazineName The name of the magazine that the user wants to subscribe to.
	 * @return The method is returning a String message that indicates whether the subscription was
	 * successful or not, and includes information such as the new balance of the user, the invoice, and
	 * any error messages.
	 */
	public String subscribeToAMagazine(String userId, String magazineName) {
		String msg = "";

		Magazine magazine = (Magazine) findProductByName(magazineName);
		User user = findUserById(userId);

		if (magazine != null) {//if the magazine exists
			if (user != null) {//if the user exists
				if (user instanceof PremiumUser || ( (RegularUser)user ).getMagazinesSuscribed() < 2) {//if the user is premium or regular and has not suscribed to 5 magazines
					if (user.getBalance() >= magazine.getPrice()) {//if the user has enough money
						Invoice invoice = new Invoice(magazine.getName(), magazine.getPrice(), Calendar.getInstance());//create a new invoice
						user.getLibrary().addProduct(magazine);//add the magazine to the user's library
						user.addInvocie(invoice);
						user.setBalance(user.getBalance() - magazine.getPrice());//subtract the price of the magazine to the user's balance
						msg = "Magazine " + magazine.getId() + " suscribed successfully!!!" + "\n" + "Your new balance is: $ " + user.getBalance()
						+ "\n" + invoice.toString();
						magazine.setSubscriptions(1);

						if (user instanceof RegularUser) {
							( (RegularUser) user ).setMagazinesSuscribed(1);
						}

					} else {
						msg = "Insufficient funds";
					}
				} else {
					msg = "\n You have already suscribed to 2 magazines, upgrade to premium to suscribe to more magazines!!! \n";
				}

			} else {
				msg = "User not found";
			}
		} else {
			msg = "Magazine not found";
		}
		
		return msg;
	}

	/**
	 * The function allows a user to unsubscribe to a magazine if they have already subscribed to it, and returns a message indicating the success or
	 * failure of the unsubscription.
	 * @param userId A string representing the ID of the user who wants to unsubscribe to a magazine.
	 * @param magazineId The ID of the magazine that the user wants to unsubscribe to.
	 * @return The method is returning a String message that indicates whether the unsubscription was
	 * successful or not, and includes information such as the new balance of the user, the invoice, and
	 */
	public String unsubscribeOfAMagazine(String userId, String magazineId) {

		String msg = findUserById(userId).unsubscribeOfAMagazine(magazineId);

		return msg;	
	}

	/**
	 * The function displays an advertisement based on the user's type, the product type, and the current
	 * page.
	 * 
	 * @param userId A string representing the unique identifier of a user.
	 * @param productId The ID of the product being displayed on the current page.
	 * @param currentPage The current page number of the product being displayed.
	 * @return The method is returning a String variable named "advertisement" which contains an
	 * advertisement message based on certain conditions.
	 */
	public String displayAdvertising(String userId, String productId, int currentPage) {
		String advertisement = "";

		
		String[] advertisements = {
			"Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!",
			"Now your pets have a favorite app: Laika. The best products for your furry friend.",
			"It's our anniversary! Visit your nearest Éxito and be surprised with the best offers."};
		
		User user = findUserById(userId);

		int random = (int) (Math.random() * 3);

		if (user instanceof RegularUser) {
			if (findProductById(productId) instanceof Magazine) {
				if (currentPage == 1 || currentPage % 5 == 0) {
					advertisement = "Advertisement:\n" + advertisements[random];
				}
			} else {
				if (currentPage == 1 || currentPage % 20 == 0) {
					advertisement = "Advertisement:\n" + advertisements[random];
				}
			}
		}

		return advertisement;

	}

}