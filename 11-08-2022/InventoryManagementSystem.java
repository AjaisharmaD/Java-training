/**
 * Created a Mini Inventory Management System for the mobile shop
 * It is used for add update and chek availability of the products which are present in the Mobile Shop
 * so the shop owner can easily manage the stocks in their shop
 * version 1.0
 * @author Ajaisharma D
 */

import java.util.Scanner;

/**
 * The mobile shop owner wants add, update and check the Mobile products in their shop.
 * They can add the products by entering how many products they want to add
 * They can update the products by entering how many products they want to update
 * They can check the products Availability by entering the products name 
 */
public class InventoryManagementSystem {
    public static void main (String[] args) {
	Scanner getInput = new Scanner(System.in);
	System.out.println("Enter the no of products to enter:");
	int count = getInput.nextInt(); 

	// Array variables to store each details
	String[] itemName = new String[count];
	int[] itemQuantity = new int[count];
	int[] itemId = new int[count];
	int[] itemPrice = new int[count];
	int[] soldItems = new int[count];

	// Commonly used variables
	boolean active = true;    
	int index;
	int id;

	// values of case
	final static int ADD = 1;
	final static int DISPLAY = 2;
	final static int SALES_ORDER = 3;
	final static int AVAILABILITY = 4;
	final static int SIGNOUT = 5;
	
	while(active) {
	    System.out.println("Enter the operation to perform\n" 
				+ "1.Add products\n"
				+ "2.Disply the products\n"
				+ "3.Add Seles Count of Product\n" 
				+ "4.Check Availability of Product\n"
				+ "5.Quit from Operations");
	    int choice = getInput.nextInt();
	    switch(choice) {
	    case ADD:			
	        System.out.println("Enter the Product Details ");
		
	        for (index = 0; index < count; index++) {
		    System.out.println("Enter " + (index+1) + "'st Product's Detail");
		    System.out.print("Enter the Item's ID: ");
		    id = getInput.nextInt();		
		    itemId[index] = id;
		    System.out.print("Enter the Item's Name: ");
	            getInput.nextLine();
		    String name = getInput.nextLine();
		    itemName[index] = name;
		    System.out.print("Enter the Item's Count: ");
		    int quantity = getInput.nextInt();
		    itemQuantity[index] = quantity;
		    System.out.print("Enter the Item's Price: ");
		    int price = getInput.nextInt();
		    itemPrice[index] = price;
	        }
	        break; 
 
	    case DISPLAY:
		System.out.println("The Products DataBase");

		    for (index = 0; index < count; index++) {
			System.out.println("Details of product Id " + itemId[index] );
			System.out.println("Item's ID: " + itemId[index] 
						+ "\nItem's Name: " + itemName[index] 
						+ "\nItem's Quantity " + itemQuantity[index] 
						+ "\nItem's Price " + itemPrice[index]);
		    }
		break;

	    case SALES_ORDER:			 
		System.out.println("The sales count");
		System.out.println("Enter the product id to add the sales count");
		id = getInput.nextInt();			
		
		for (index = 0; index < count; index++) {
		    if(itemId[index] == id) { 
			System.out.println("Enter the number of products sold");
			soldItems[index] = getInput.nextInt();
			System.out.println("Number of item sold in" + itemId[index] + " " + soldItems[index]);
			itemQuantity[index] = itemQuantity[index] - soldItems[index];
		    }
		}
		break;

	    case AVAILABILITY:		 
		System.out.println("Checking availability");
		System.out.println("Enter the product's Id to check availability");
		id = getInput.nextInt();
		
		for (index = 0; index < count; index++) {
		    if(itemId[index] == id) 
			System.out.println("Number of item Availabile in " 
						+ itemName[index] + " " 
						+ itemQuantity[index]);
		}
		break;	

	    case SIGNOUT:	
		System.out.println("You entered Signout\n" 
					+ "Are you sure to Signout\n" 
					+ "1.yes\t\t  2.no");
		int logout = getInput.nextInt();
		
		if(logout == 1) {
		    active = false;
		}
		break;

	    default :
		if(active) {
		    System.out.println("The process is ended");
		} else {
		    System.out.println("You have entered a incorrect" 
				+ "Choice please enter correct Choice");
		}
		break;	
	
	    }
        }   	
    }
}
