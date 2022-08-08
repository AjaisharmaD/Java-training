import java.util.Scanner;

class InventoryManagementSystem {
    /*
     * The mobile shop owner wants add, update and check the Mobile products in their shop.
     * They can add the products by entering how many products they want to add
     * They can update the products by entering how many products they want to update
     * They can check the products Availability by entering the products name 
     */
    public static void main(String[] args) {
	Scanner getInput = new Scanner(System.in);
	System.out.println("Enter the no of products to enter:");
	int no_of_products = getInput.nextInt(); 
	String[] itemName = new String[no_of_products];
	int[] itemQuantity = new int[no_of_products];
	int[] itemId = new int[no_of_products];
	int[] itemPrice = new int[no_of_products];
	int[] selledItems = new int[no_of_products];
	int active = 1;
	int i;
	
	while(active != 0) {
	    System.out.println("Enter the operation to perform\n 1.Add products\n 2.Add Seles Count of Product\n 3.Check Availability of Product\n 4.Quit from Operations");
	    int choice = getInput.nextInt();
	    switch(choice) {
	    case 1:										// This case is used add the product details
	        System.out.println("Enter the Product Details ");
		
	        for(i=0; i<no_of_products; i++) {
		    System.out.print("Enter the Item's ID: ");
		    int id = getInput.nextInt();
		    itemId[i] = id;
		    System.out.print("Enter the Item's Name: ");
	            getInput.nextLine();
		    String name = getInput.nextLine();
		    itemName[i] = name;
		    System.out.print("Enter the Item's Count: ");
		    int quantity = getInput.nextInt();
		    itemQuantity[i] = quantity;
		    System.out.print("Enter the Item's Price: ");
		    int price = getInput.nextInt();
		    itemPrice[i] = price;	
		    System.out.println("Item's ID: " + itemId[i] + "\nItem's Name: " + itemName[i] + "\nItem's Quantity " + itemQuantity[i] + "\nItem's Price " + itemPrice[i]);
	        }
	        break;  

	    case 2:										// this case is used to add the sale count of a product
		System.out.println("The sales count");
		System.out.println("Enter the product id to add the sell count");
		int id = getInput.nextInt();
		
		for (i = 0; i < no_of_products; i++) {
		    if(itemId[i] == id) { 
			System.out.println("Enter the number of products selled");
			selledItems[i] = getInput.nextInt();
			itemQuantity[i] = itemQuantity[i] - selledItems[i];
			System.out.println("Number of item selled" + selledItems[i]);
		    }
		}
		break;

	    case 3:										// this case used check the availability of a product 
		System.out.println("Checking availability");
		System.out.println("Enter the product's Id to check availability");
		id = getInput.nextInt();
		
		for (i = 0; i< no_of_products; i++) {
		    if(itemId[i] == id) 
			System.out.println("Number of item Availabile in " + itemName[i] + " " + itemQuantity[i]);
		}
		break;	

	    case 4:										// this case is used to get the confirmation and end the process
		System.out.println("You entered Quit option \n Are you sure to quite\n 1.yes\n 2.no");
		int quitOption = getInput.nextInt();
		
		if(quitOption == 1) 
		    active = 0;
		else
		    break;

	    default :
		System.out.println("You have entered a incorrect Choice please enter correct Choice");
		break;		
	    }
        }   	
    }
}