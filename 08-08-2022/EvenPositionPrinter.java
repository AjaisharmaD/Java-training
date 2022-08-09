import java.util.Scanner;

/* 
 * This classs is used to print the even position elements in the int array
 */  
class EvenPositionPrinter {
    public static void main(String[] args) {
	Scanner getInput = new Scanner(System.in);
	System.out.println("Enter the number of Elements");
	int no_of_elements = getInput.nextInt();
	int[] numbers = new int[no_of_elements];
	int iterator;
	
	for(iterator = 0; iterator <no_of_elements; iterator++) { 			// Getting the int array elements from the console
	    numbers[iterator] = getInput.nextInt();
	}
	
	for(iterator = 0; iterator < no_of_elements; iterator = iterator+2) {
	    System.out.println("The Even position elements are " + numbers[iterator]);	// Printing the int array's even Positioned elements 
	}
    }
}
