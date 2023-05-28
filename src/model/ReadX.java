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
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equalsIgnoreCase(userId)) {
				user = users.get(i);
			}
		}
		return user;
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
		BibliographicProduct product = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getId().equalsIgnoreCase(productId)) {
					product = products.get(i);
				}
			} else {
				if ( ( (Book) products.get(i) ).getId().equalsIgnoreCase(productId)) {
					product = products.get(i);
				}
			} 
		}
		return product;
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
		BibliographicProduct product = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getName().equalsIgnoreCase(productName)) {
					product = products.get(i);
				}
			} else {
				if ( ( (Book) products.get(i) ).getName().equalsIgnoreCase(productName)) {
					product = products.get(i);
				}
			} 
		}
		return product;
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
			bookGenre = Genre.SCIENCE_FICTION;
		} 
		else if (genre == 2) {
			bookGenre = Genre.FANTASY;
		} 
		else {
			bookGenre = Genre.HISTORICAL_NOVEL;
		}

		BibliographicProduct book = new Book(name, pages, publicationDate, url, price, review, bookGenre);

		products.add(book);

		msg += "\nBook information:" + "\n" + book.toString();

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
		Calendar calendar = Calendar.getInstance();


		msg += "------------------\n"
				+ "Users:\n"
				+ "------------------\n";

		//register 1 premium user and 1 regular user
		for (int i = 1; i < 3; i++) {
			msg += "\n(" + (i) + ") " + registerUser("User" + i, "id" + i, 9999999999999.9, i);
		}

		msg += "\n------------------\n"
				+ "Books:\n"
				+ "------------------\n";

		//register 3 books by genre 
		for (int i = 1; i < 4; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, i);
			msg += "\n(" + (i) + ") " + registerBook("book" + i, 30, calendar, "thing.jpg", 10.0, "Very good", i);
		}

		msg += "\n------------------\n"
				+ "Magazines:\n"
				+ "------------------\n";

		//register 3 magazines by category
		for (int i = 1; i < 4; i++) {
			calendar.add(Calendar.DAY_OF_MONTH, i);
			msg += "\n(" + (i) + ") " + registerMagazine("magazine" + i, 25, calendar, "thing1.jpg", 5.0, "Weekly", i);
		}

		// subscribe User1 to 51 magazines 
		for (int i = 0; i < 51 ; i++) {
			if (i % 2 == 0) {
				subscribeToAMagazine("id1", "magazine3");
			} else if (i % 3 == 0) {
				buyBook("id1", "book3");
			} else {
				subscribeToAMagazine("id1", "magazine2");
			}
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
						bookGenre = Genre.SCIENCE_FICTION;
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
				if (((Magazine) products.get(i)).getId().equalsIgnoreCase(productId)) {
					BibliographicProduct product = products.get(i);
					product = null;
					products.remove(i);
					msg = "Magazine deleted successfully!!!";
					productFound = true;
					break;// get out of the loop after deleting the product
				}
			} else if (products.get(i) instanceof Book) {
				if (((Book) products.get(i)).getId().equalsIgnoreCase(productId)) {
					products.remove(i);
					BibliographicProduct product = products.get(i);
					product = null;
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

		for (int i = 0; i < users.size(); i++) {
			users.get(i).getLibrary().updateLibrary(productId);
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
						book.setTotalSales();

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

						magazine.setUnitsSold(1);
						magazine.setTotalSales();

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

		String msg = findUserById(userId).getLibrary().unsubscribeOfAMagazine(magazineId);

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


	/**
	 * This function handles a reading session for a user on a specific product, allowing them to navigate
	 * through the pages and displaying relevant information.
	 * 
	 * @param input A string representing the user's input, which can be "s" for next page, "a" for
	 * previous page, or "b" for finish reading.
	 * @param userId A string representing the unique identifier of the user who is currently reading a
	 * book.
	 * @param productId The ID of the bibliographic product being read in the current reading session.
	 * @return A string message containing information about the reading session, including the current
	 * page being read, the name and ID of the product being read, and options for navigating through the
	 * pages. The message may also include advertising information.
	 */
	public String readingSession(String input, String userId, String productId) {
		String msg = "";

		User user = findUserById(userId);

		if (productId.contains(",")) {
			String[] coordinates = productId.split(",");//split the input into an array of strings based on the comma
			// convert the strings into integers
			int x = Integer.parseInt(coordinates[0]);
			int y = Integer.parseInt(coordinates[1]);


			Library userLibrary = user.getLibrary();
			ArrayList<String[][]> shelfs = userLibrary.getShelfs();
			String[][] shelf = shelfs.get(userLibrary.getCurrentShelf());
			//get the id of the product in the selected cell
			productId = shelf[y+1][x+1].substring(1,4);// add 1 to the x coordinate because the first row and column are the numbers of the rows and column
		} 

		BibliographicProduct product = findProductById(productId);

		String[] pages = product.getSheets();

		ReadingSession readingSession = user.getLibrary().getReadingSession(productId);	

		int currentPage = readingSession.getCurrentPage();


		if (input.equalsIgnoreCase("s")) {
			if (currentPage == pages.length-1) {
				readingSession.setCurrentPage(0);
			} else {
				readingSession.updateCurrentPage(1);
			}
		} else if (input.equalsIgnoreCase("a")) {
			if (currentPage == 0) {
				msg += "You are in the first page!!!";
			} else {
				readingSession.updateCurrentPage(-1);
			}
		} 

		product.setPagesRead(1);
		msg += "\n" + "Reading Session in progress: " + "\n";

		msg += "\n" + displayAdvertising(userId, productId, readingSession.getCurrentPage()+1) + "\n";
		msg += "\n" + "Reading: " + product.getName() + " ID: " + product.getId() + "\n";
		msg += "\n" + pages[readingSession.getCurrentPage()] + " of " + pages.length + "\n";
		msg += "\n (s) Next page \n (a) Previous page \n (b) Finish reading \n";
	
		return msg;
	}


	/**
	 * The function displays the user's library and allows them to navigate through their shelves and
	 * select a product to start a reading session.
	 * 
	 * @param input A string representing the user's input, which can be "s" to move to the next shelf, "a"
	 * to move to the previous shelf, or the ID of a product to start a reading session.
	 * @param userId The ID of the user whose library is being accessed.
	 * @return The method is returning a String that represents the user's library, including the current
	 * shelf and its contents, as well as options to navigate to the next or previous shelf, exit the
	 * library, and start a reading session by entering a product's id. If the user's library is empty, the
	 * method returns a message indicating so and an option to go back to the main menu.
	 */
	public String library(String input, String userId) {
		User user = findUserById(userId);

		String shelf = "";

		if (user.getLibrary().getShelfs().size() == 0) {
			shelf = "Your library is empty!!!";
			shelf += "\n" + "Press (e) to go back to the main menu";
		} else {

			shelf = user.getName() + "'s library: \n";
			
			Library library = user.getLibrary();
	
			int currentShelf = library.getCurrentShelf();
	
			if (input.equalsIgnoreCase("s")) {
				if (currentShelf == library.getShelfs().size()-1) {
					library.setCurrentShelf(0);
				} else {
					library.updateCurrentShelf(1);
				}
			} else if (input.equalsIgnoreCase("a")) {
				if (currentShelf == 0) {
					shelf += "\n You are in the first shelf!!! \n";
				} else {
					library.updateCurrentShelf(-1);
				}
			}
	
			shelf += "\n" + "Shelf: " + (library.getCurrentShelf()+1) + "\n";
			shelf += library.showShelf() + "\n";
			shelf += "\n (s) Next shelf \n (a) Previous shelf \n (e) Exit \n";
			shelf += "\nPlease enter the product's id or coordinates x,y (ex: '2,4')to start a reading session: \n";

		}

		return shelf;

	}

	/**
	 * This function calculates and returns the total number of pages read for books and magazines in the
	 * list of products.
	 * 
	 * @return The method is returning a String report that contains the total number of pages read for
	 * books and magazines in the products list.
	 */
	public String viewTotalPagesRead() {
		String report = "";
		int totalPagesReadBooks = 0;
		int totalPagesReadMagazines = 0;

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				totalPagesReadMagazines += ( (Magazine) products.get(i) ).getPagesRead();
			} else {
				totalPagesReadBooks += ( (Book) products.get(i) ).getPagesRead();
			} 
		}

		report += "\n Total pages read: \n Books: " + totalPagesReadBooks + "\n Magazines: " + totalPagesReadMagazines + "\n";
	

		return report;
	}

	/**
	 * The function calculates and returns the most read genre and category of products in the list of
	 * products, along with the number of pages read for each.
	 * 
	 * @return A report containing the most read genre and category, along with the number of pages read
	 * for each.
	 */
	public String viewMostReadGenreAndCategory() { 
		String report = "";

		String genreMostRead = ""; // name of the most read genre
		String categoryMostRead = ""; // name of the most read category

		// pages read genres
		int pagesReadScienceFiction = 0;
		int pagesReadFantasy = 0;
		int pagesReadHistoricalNovel = 0;

		//pages read categories
		int pagesReadVarities = 0;
		int pagesReadDesing = 0;
		int pagesReadScientific = 0;


		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				if ( ( (Magazine) products.get(i) ).getCategory().getName().equalsIgnoreCase("Varities") ) {
					pagesReadVarities += ( (Magazine) products.get(i) ).getPagesRead();
				} else if ( ( (Magazine) products.get(i) ).getCategory().getName().equalsIgnoreCase("Desing") ) {
					pagesReadDesing += ( (Magazine) products.get(i) ).getPagesRead();
				} else if ( ( (Magazine) products.get(i) ).getCategory().getName().equalsIgnoreCase("Scientific") ) {
					pagesReadScientific += ( (Magazine) products.get(i) ).getPagesRead();
				}
			} else {
				if ( ( (Book) products.get(i) ).getGenre().getName().equalsIgnoreCase("Science fiction") ) {
					pagesReadScienceFiction += ( (Book) products.get(i) ).getPagesRead();
				} else if ( ( (Book) products.get(i) ).getGenre().getName().equalsIgnoreCase("Fantasy") ) {
					pagesReadFantasy += ( (Book) products.get(i) ).getPagesRead();
				} else if ( ( (Book) products.get(i) ).getGenre().getName().equalsIgnoreCase("Historical novel") ) {
					pagesReadHistoricalNovel += ( (Book) products.get(i) ).getPagesRead();
				}
			} 
		}

		int pagesGenreMostRead = 0;
		//The most read genre
		if (pagesReadScienceFiction > pagesReadFantasy && pagesReadScienceFiction > pagesReadHistoricalNovel) {
			genreMostRead = "Science fiction";
			pagesGenreMostRead = pagesReadScienceFiction;
		} else if (pagesReadFantasy > pagesReadScienceFiction && pagesReadFantasy > pagesReadHistoricalNovel) {
			genreMostRead = "Fantasy";
			pagesGenreMostRead = pagesReadFantasy;
		} else if (pagesReadHistoricalNovel > pagesReadScienceFiction && pagesReadHistoricalNovel > pagesReadFantasy) {
			genreMostRead = "Historical novel";
			pagesGenreMostRead = pagesReadHistoricalNovel;
		} else {
			genreMostRead = "There is no most read genre";
		}

		int pagesCategoryMostRead = 0;
		//The most read category
		if (pagesReadVarities > pagesReadDesing && pagesReadVarities > pagesReadScientific) {
			categoryMostRead = "Varities";
			pagesCategoryMostRead = pagesReadVarities;
		} else if (pagesReadDesing > pagesReadVarities && pagesReadDesing > pagesReadScientific) {
			categoryMostRead = "Desing";
			pagesCategoryMostRead = pagesReadDesing;
		} else if (pagesReadScientific > pagesReadVarities && pagesReadScientific > pagesReadDesing) {
			categoryMostRead = "Scientific";
			pagesCategoryMostRead = pagesReadScientific;
		} else {
			categoryMostRead = "There is no most read category";
		}

		report = "The genre most read is: " + genreMostRead + "\n" + "Pages read: " + pagesGenreMostRead + "\n" + 
		"The category most read is: " + categoryMostRead + "\n" + "Pages read: " + pagesCategoryMostRead + "\n";


		return report;
	}

	/**
	 * The function returns a report of the top 5 most read books and magazines, sorted by
	 * pages read.
	 * 
	 * @return The method is returning a String that contains a report of the top 5 most read books and
	 * magazines, including their name, pages read, and genre/category.
	 */
	public String viewTop5() {
		String report = "";

		ArrayList<BibliographicProduct> top5Books = new ArrayList<BibliographicProduct>();

		ArrayList<BibliographicProduct> top5Magazines = new ArrayList<BibliographicProduct>();

		//Separate the books from the magazines
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				top5Magazines.add(products.get(i));
			} else {
				top5Books.add(products.get(i));
			}
			
		}

		top5Books = bubbleSort(top5Books);// sort the books by pages read
		top5Magazines = bubbleSort(top5Magazines); // sort the magazines by pages read

		report += "\n Top 5 most read books on the platform: \n";

		for (int i = 0; i < top5Books.size() && i < 5; i++) {
			report += "\n" + (i+1) + ". " + top5Books.get(i).getName() + 
			"\nPages read: " + top5Books.get(i).getPagesRead() + 
			"\nGenre: " + ( (Book) top5Books.get(i) ).getGenre().getName() + "\n";
		}


		report += "\n Top 5 most read magazines on the platform: \n";

		for (int i = 0; i < top5Magazines.size() && i < 5; i++) {
			report += "\n" + (i+1) + ". " + top5Magazines.get(i).getName() + 
			"\nPages read: " + top5Magazines.get(i).getPagesRead() +
			"\nCategory: " + ( (Magazine) top5Magazines.get(i) ).getCategory().getName() + "\n";
		}

		return report;
	}

	/**
	 * This function implements bubble sort algorithm to sort the ArrayList of BibliographicProduct objects
	 * based on their pages read in descending order.
	 * 
	 * @param products An ArrayList of BibliographicProduct objects that need to be sorted based on their
	 * pagesRead attribute. The bubbleSort method uses a bubble sort algorithm to sort the products in
	 * descending order of pagesRead.
	 * @return The method is returning an ArrayList of BibliographicProduct objects that has been sorted in
	 * descending order based on the number of pages read.
	 */
	public ArrayList<BibliographicProduct> bubbleSort(ArrayList<BibliographicProduct> products) {

		for (int i = 0; i < products.size(); i++) {
			for (int j = 0; j < products.size()-1; j++) {
				if (products.get(j).getPagesRead() < products.get(j+1).getPagesRead()) {
					BibliographicProduct temp = products.get(j);
					products.set(j, products.get(j+1));
					products.set(j+1, temp);
				}
			}
		}
		return products;
	}

	/**
	 * This function generates a report of books sold by genre, including the total sales and units sold
	 * for each genre.
	 * 
	 * @return The method is returning a String report that contains the total sales and units sold for
	 * each book genre (Science fiction, Fantasy, and Historical Novel).
	 */
	public String booksSoldByGenre() {
		String report = "";

		double salesScienceFiction = 0;
		double salesFantasy = 0;
		double salesHistoricalNovel = 0;

		int scienceFictionBooksSold = 0;
		int fantasyBooksSold = 0;
		int historicalNovelBooksSold = 0;

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Book) {
				Book book = (Book) products.get(i);

				if ( book.getGenre().getName().equalsIgnoreCase("Science fiction") && book.getUnitsSold() > 0 ) {
					scienceFictionBooksSold += book.getUnitsSold();
					salesScienceFiction += book.getTotalSales();
				} else if ( book.getGenre().getName().equalsIgnoreCase("Fantasy") && book.getUnitsSold() > 0 ) {
					fantasyBooksSold += book.getUnitsSold();
					salesFantasy += book.getTotalSales();
				} else if ( book.getGenre().getName().equalsIgnoreCase("Historical Novel") && book.getUnitsSold() > 0 ) {
					historicalNovelBooksSold += book.getUnitsSold();
					salesHistoricalNovel += book.getTotalSales();
				}
			}
		}

		report = "Books sold by genre: \n" + 
		"- Science fiction: $ " + salesScienceFiction + "\n" + 
		"Units sold: " + scienceFictionBooksSold + "\n" +
		"- Fantasy: $ " + salesFantasy + "\n" + 
		"Units sold: " + fantasyBooksSold + "\n" +
		"- Historical novel: $ " + salesHistoricalNovel + "\n" +
		"Units sold: " + historicalNovelBooksSold + "\n";

		return report;
	}
	
	/**
	 * This function generates a report of the total sales and active subscriptions for each category of
	 * magazines sold.
	 * 
	 * @return The method is returning a String report that contains the total sales and active
	 * subscriptions for each category of magazines sold.
	 */
	public String magazinesSoldByCategory() {
		String report = "";

		double salesVarities = 0;
		double salesDesing = 0;
		double salesScientific = 0;

		int varitiesMagazinesSold = 0;
		int desingMagazinesSold = 0;
		int scientificMagazinesSold = 0;

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i) instanceof Magazine) {
				Magazine magazine = (Magazine) products.get(i);
				if ( magazine.getCategory().getName().equalsIgnoreCase("Varities") && magazine.getUnitsSold() > 0 ) {
					varitiesMagazinesSold += magazine.getUnitsSold();
					salesVarities += magazine.getTotalSales();
				} else if ( magazine.getCategory().getName().equalsIgnoreCase("Desing") && magazine.getUnitsSold() > 0 ) {
					desingMagazinesSold += magazine.getUnitsSold();
					salesDesing += magazine.getTotalSales();
				} else if ( magazine.getCategory().getName().equalsIgnoreCase("Scientific") && magazine.getUnitsSold() > 0 ) {
					scientificMagazinesSold += magazine.getUnitsSold();
					salesScientific += magazine.getTotalSales();
				}
			}
		}

		report = "Magazines sold by category: \n" +
		"- Varities: $ " + salesVarities + "\n" +
		"Active subscriptions: " + varitiesMagazinesSold + "\n" +
		"- Desing: $ " + salesDesing + "\n" +
		"Active subscriptions: " + desingMagazinesSold + "\n" +
		"- Scientific: $ " + salesScientific + "\n" +
		"Active Subscriptions: " + scientificMagazinesSold + "\n";

		return report;
	}

}