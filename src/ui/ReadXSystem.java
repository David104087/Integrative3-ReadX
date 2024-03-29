/**
 * @author [David Artunduaga Penagos]
 * @version [1.0]
 * @since [13/05/2023]
 */
package ui;
import java.util.Scanner;
import model.ReadX;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher; // to validate the date format
import java.util.regex.Pattern;

/**
 * This class represents the user interface of the program.
 */
public class ReadXSystem {

	/**
	 * This variable will be used to read input from the user. 
	 */
	private Scanner sc;

	/**
	 * This variable represents the conection between the ui and the model.
	 */
	private ReadX controller;

	public ReadXSystem() {
		sc = new Scanner(System.in);
		controller = new ReadX();
	}

	/**
	 * The main function creates an object of the ReadXSystem class, displays a menu, validates user input,
	 * and executes the selected option until the user chooses to exit.
	 * @param args An array of Strings that stores the arguments passed by the user through the console.
	 */
	public static void main(String[] args) {
		ReadXSystem view = new ReadXSystem(); //create an object of the class
		int option = 0; 

		
        do{
            view.menu(); 
            option = view.validateIntegerInput(); 
            view.executeOption(option);
        }while(option != 14);


        view.sc.close();
	}


	/**
	 * The function displays a menu with options for the program.
	 */
	public void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("Welcome to ReadX, please select an option:  ");
		System.out.println("--------------------------------------------");
		System.out.println("\n(0) Init ReadX \n(1) Register a new user \n(2) Register a new product \n(3) Modify a product \n(4) Delete a product \n(5) Buy a book \n(6) Suscribe to a magazine \n(7) Unsubscribe of a magazine \n(8) Library \n(9) View total pages read \n(10) View most read genre and category \n(11) View top 5 of most read books and magazines	\n(12) Books sold by genre \n(13) Magazines subscribed by category \n(14) Exit \n Select an option:");

	}

	/**
	 * This function executes different options based on the input parameter using a switch statement.
	 * 
	 * @param option an integer representing the user's selected option from the menu. The method executes a
	 * specific action based on the selected option.
	 */
	public void executeOption(int option){
		switch(option){
			case 0: 
				initReadX(); 
				break;
			case 1: 
				registerUser(); 
				break; 
			case 2: 
				registerProduct(); 
				break; 
			case 3: 
				modifyProduct(); 
				break; 
			case 4: 
				deleteProduct(); 
				break; 
			case 5: 
				buyBook(); 
				break; 
			case 6: 
				subscribeToAMagazine(); 
				break; 
			case 7: 
				unsubscribeOfAMagazine(); 
				break; 
			case 8: 
				library(); 
				break; 
			case 9: 
				viewTotalPagesRead();
				break; 
			case 10:
				viewMostReadGenreAndCategory();
				break;
			case 11:
				viewTop5();
				break;
			case 12:
				booksSoldByGenre();
				break;
			case 13:
				magazinesSoldByCategory();	
				break;
			case 14:
				System.out.println("Bye!"); 		
				break;
			default: 
				System.out.println("Invalid option"); 
				break; 
		}
	}

	/**
     * This method validates the user's input and returns the selected option as an integer.
     * 
     * @return An integer representing the user's selected option.
     */
    public int validateIntegerInput(){
        int option = 0; 
        if(sc.hasNextInt()){
            option = sc.nextInt(); 
            sc.nextLine();
        }
        else{
            sc.nextLine();// clear the scanner 
            option = -1; 
            System.out.println("Enter an integer value"); 
        }
        return option; 
    }


	/**
	 * This function registers a user by taking input for their name, id, balance, and user type, and then
	 * displays their information.
	 */
	public void registerUser() {
		String name = "";
		String id = "";
		int userType = 0;
		String msg;

		System.out.println("Please enter the type of user: \n(1) Premium \n(2) Regular");
		userType = validateIntegerInput();
		System.out.println("Please enter the user's name: ");
		name = sc.nextLine();
		System.out.println("Please enter the user's id: ");
		id = sc.nextLine();
		System.out.println("Please enter the user's balance: ");
		double balance = sc.nextDouble();

		msg = controller.registerUser(name, id, balance, userType);
		System.out.println(msg);

	}

	/**
	 * This function registers products (books or magazines) by taking user input for their attributes
	 * and calling the method in the controller class.
	 */
	public void registerProduct() {
		String name = "";
		int pages = 0;
		String publicationDate = "";
		String url = "";
		double price = 0;
		int productType = 0;
		String msg = "";

		System.out.println("Please enter the type of product: \n(1) Book \n(2) Magazine");
		productType = validateIntegerInput();
		System.out.println("Please enter the product's name: ");
		name = sc.nextLine();
		System.out.println("Please enter the product's pages: ");
		pages = validateIntegerInput();

		//regular expression to verify the date format dd/mm/yyyy
		Pattern regexDate = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
		Calendar datePublication = Calendar.getInstance();
		boolean validDate = false;
		do {
			System.out.println("Please enter the product's publication date (dd/mm/yyyy): ");
			publicationDate = sc.nextLine();

			Matcher matcher = regexDate.matcher(publicationDate);//match the date with the regular expression

			if (matcher.matches()) {//if the date matches the regular expression
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					dateFormat.setLenient(false);//not accept invalid dates like 31/02/2021
					datePublication.setTime(dateFormat.parse(publicationDate));
					validDate = true;
				} catch (Exception e) {
					System.out.println("Invalid date");
				}
			} else {
				System.out.println("Invalid date format");
			}
		} while (!validDate);

		System.out.println("Please enter the product's url: ");
		url = sc.nextLine();
		System.out.println("Please enter the product's price: ");
		price = sc.nextDouble();
		sc.nextLine();
				
		if(productType == 1){
			System.out.println("Please enter the book's review: ");
			String review = sc.nextLine();
			System.out.println("Please enter the book's genre \n(1) Sciencie Fiction \n(2) Fantasy \n(3) Historical Novel");
			int genre = validateIntegerInput();

			msg = controller.registerBook(name, pages, datePublication, url, price, review, genre);
		}
		else if(productType == 2){
			System.out.println("Please enter the periodicity of issue of the magazine: ");
			String periodicity = sc.nextLine();
			System.out.println("Please enter the magazine's category \n(1) Varities \n(2) Desing \n(3) Scientific");
			int category = validateIntegerInput();

			msg = controller.registerMagazine(name, pages, datePublication, url, price, periodicity, category);
		}
		else{
			System.out.println("Invalid option");
		}

		System.out.println(msg);
	}

	/**
	 * This function initializes the program and prints a message with the info of users and products created
	 */
	public void initReadX() {
		String msg = controller.initReadX();
		System.out.println(msg);
	}


	/**
	 * This function modifies a product's attribute based on user input and displays the updated product
	 * information.
	 */
	public void modifyProduct() {
		String id = "";
		int dataToModify = 0;
		String newStatus = "";
		String msg = "";

		System.out.println("Please enter the product's id: ");
		id = sc.nextLine();

		System.out.println("Product information: \n" + controller.findProductById(id).showAttributesToModify());
		System.out.print("Please enter the number of the attribute you want to modify: ");
		dataToModify = validateIntegerInput();
		System.out.println("Please enter the new value: ");
		newStatus = sc.nextLine();
		msg = controller.modifyProduct(id, dataToModify, newStatus);
		System.out.println(msg);
		System.out.println("Product information: \n" + controller.findProductById(id).toString() + "\n");
	}

	/**
	 * This function prompts the user to enter a product ID and then calls a controller method to
	 * delete the corresponding product.
	 */
	public void deleteProduct() {
		String id = "";
		String msg = "";

		System.out.println("Please enter the product's id: ");
		id = sc.nextLine();

		msg = controller.deleteProduct(id);
		System.out.println(msg);
	}

	/**
	 * This function allows a user to buy a book by entering their user ID and the book's name, and then
	 * confirming their purchase decision.
	 */
	public void buyBook() {
		String userId = "";
		String bookName = "";
		String msg = "";
		int option = 0;
		int decision = 1;

		System.out.println("Please enter the user's id: ");
		userId = sc.nextLine();

		do {
			System.out.println("Please enter the book's name: ");
			
			bookName = sc.nextLine();
	
			if (controller.findProductByName(bookName) == null) {
				System.out.println("The book does not exist");
			} else {
				System.out.println("Book information: \n" + controller.findProductByName(bookName).toString() + "\n");
				System.out.println("Want to buy this book? \n(1) Yes \n(2) No");
				option = validateIntegerInput();
		
				if (option == 1) {
					msg = controller.buyBook(userId, bookName);
					System.out.println(msg);
				} else {
					System.out.println("The book was not purchased");
				}
			}

			System.out.println("Want to buy another book? \n(1) Yes \n(2) No");
			decision = validateIntegerInput();
			
		} while (decision == 1);

	}

	/**
	 * This function allows a user to subscribe to a magazine by entering their user ID and the magazine's name, and then
	 * confirming their subscription decision.
	 */
	public void subscribeToAMagazine() {
		String userId = "";
		String magazineId = "";
		String msg = "";
		int option = 0;
		int decision = 1;

		System.out.println("Please enter the user's id: ");
		userId = sc.nextLine();

		do {
			System.out.println("Please enter the magazine's name: ");
			magazineId = sc.nextLine();

			if (controller.findProductByName(magazineId) == null) {
				System.out.println("The magazine does not exist");
			} else {
				System.out.println("Magazine information: \n" + controller.findProductByName(magazineId).toString() + "\n");
				System.out.println("Want to subscribe to this magazine? \n(1) Yes \n(2) No");
				option = validateIntegerInput();
	
				if (option == 1) {
					msg = controller.subscribeToAMagazine(userId, magazineId);
					System.out.println(msg);
				} else {
					System.out.println("The magazine was not subscribed");
				}
			}

			System.out.println("Do you want to subscribe to another magazine? \n(1) Yes \n(2) No");
			decision = validateIntegerInput();

		} while (decision == 1);

		
	}

	/**
	 * This function allows a user to unsubscribe to a magazine by entering their user ID and the magazine's name, and then
	 * confirming their unsubscription decision.
	 */
	public void unsubscribeOfAMagazine() {
		String userId = "";
		String magazineId = "";
		String msg = "";
		int option = 0;

		System.out.println("Please enter the user's id: ");
		userId = sc.nextLine();

		System.out.println("Please enter the magazine's id: ");
		magazineId = sc.nextLine();

		if (controller.findUserById(userId) == null) {
			System.out.println("The user does not exist");
		} else if (controller.findProductById(magazineId) == null) {
			System.out.println("The magazine does not exist");
		} else if (controller.findUserById(userId).getLibrary().findProductById(magazineId) == null) {
			System.out.println("The user " + userId + " is not subscribed to the magazine " + magazineId);
		} else {
			System.out.println("Magazine information: \n" + controller.findProductById(magazineId).toString() + "\n");
			System.out.println("Want to unsubscribe to this magazine? \n(1) Yes \n(2) No");
			option = validateIntegerInput();
			
	
			if (option == 1) {
				msg = controller.unsubscribeOfAMagazine(userId, magazineId);
				System.out.println(msg);
			} else {
				System.out.println("The magazine was not unsubscribed");
			}
		}
		
	
	}

	/**
	 * This function prompts the user to enter a user ID and allows them to navigate through a library
	 * to access and read the products they have purchased.
	 */
	public void library() {
		String userId = "";
		String shelf = "";
		String content = "";
		String productId = "";


		System.out.println("Please enter the user's id: ");
		userId = sc.nextLine();

		String input = "";

		while(!input.equalsIgnoreCase("E")) {
			shelf = controller.library(input, userId);
			System.out.println(shelf);
			input = sc.nextLine();
			if (input.length() > 1) { //validate that iput is not a instruction to navigate
				productId = input;
				while(!input.equalsIgnoreCase("B")) {
					content = controller.readingSession(input, userId, productId);
					System.out.println(content);
					input = sc.nextLine();
				}
			}
		}

	}

	/**
	 * This function prints the total number of pages read using the controller's viewTotalPagesRead
	 * method.
	 */
	public void viewTotalPagesRead() {
		System.out.println(controller.viewTotalPagesRead());
	}

	/**
	 * This function prints the most read genre and category using a controller method.
	 */
	public void viewMostReadGenreAndCategory() {
		System.out.println(controller.viewMostReadGenreAndCategory());
	}

	/**
	 * This function prints a report of the top 5 most read books and magazines using a controller method.
	 */
	public void viewTop5() { 
		System.out.println(controller.viewTop5());
	}

	/**
	 * This function prints out the number of books sold by genre using a controller method.
	 */
	public void booksSoldByGenre() {
		System.out.println(controller.booksSoldByGenre());
	}

	/**
	 * This function prints out the number of magazines sold by category using a controller method.
	 */
	public void magazinesSoldByCategory() {
		System.out.println(controller.magazinesSoldByCategory());
	}

}