/**
 * @author [David Artunduaga Penagos]
 * @version [1.0]
 * @since [04/04/2023]
 */
package ui;
import java.util.Scanner;
import model.ReadX;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReadXSystem {

	private Scanner sc;
	private ReadX controller;


	public ReadXSystem() {
		sc = new Scanner(System.in);
		controller = new ReadX();
	}

	public static void main(String[] args) {
		ReadXSystem view = new ReadXSystem(); //create an object of the class
		int option = 0; 

		
        do{
            view.menu(); 
            option = view.validateIntegerInput(); //set view. pa all methods as they need to be executed for that object
            view.executeOption(option);
        }while(option != 9);


        view.sc.close();
	}

	public void menu() {
		System.out.println("Welcome to ReadX, please select an option: \n(1) Register a new user \n(2) Register a new product \n(3) Modify a product \n(4) Delete a product \n(5) Buy a book \n(6) Suscribe to a magazine \n(7) Unsubscribe of a magazine \n(8) Reading session \n(9) Exit");
	}

	public void executeOption(int option){
		switch(option){
			case 1: 
				registerUser(); 
				break; 
			case 2: 
				registerProducts(); 
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
				suscribeToAMagazine(); 
				break; 
			case 7: 
				unsubscribeOfAMagazine(); 
				break; 
			case 8: 
				readingSession(); 
				break; 
			case 9: 
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

		msg = controller.registerUser(name, id, userType);
		System.out.println(msg);


		System.out.println("User information: \n" + "User type: " +  (userType == 1 ? "Premium" : "Regular") 
		+ "\n" + controller.findUserById(id).toString() + "\n");



	}

	public void registerProducts() {
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
			System.out.println("Please enter the book's publication date (dd/mm/yyyy): ");
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

		System.out.println("Please enter the book's url: ");
		url = sc.nextLine();
		System.out.println("Please enter the book's price: ");
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

	public void initReadX() {
		controller.initReadX();
	}

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
		System.out.println(msg);//ARREGLAR LO DEL GENRE Y CATEGORY
		System.out.println("Product information: \n" + controller.findProductById(id).toString() + "\n");
	}

	public void deleteProduct() {
		// TODO - implement ReadXSystem.deleteProduct
		throw new UnsupportedOperationException();
	}

	public void buyBook() {
		// TODO - implement ReadXSystem.buyBook
		throw new UnsupportedOperationException();
	}

	public void suscribeToAMagazine() {
		// TODO - implement ReadXSystem.suscribeToAMagazine
		throw new UnsupportedOperationException();
	}

	public void unsubscribeOfAMagazine() {
		// TODO - implement ReadXSystem.unsubscribeOfAMagazine
		throw new UnsupportedOperationException();
	}

	public void readingSession() {
		// TODO - implement ReadXSystem.readingSession
		throw new UnsupportedOperationException();
	}

}