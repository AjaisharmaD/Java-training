/*
 *Program to print the even number
 */
import java.util.Scanner;
class EvenNumber {
    public static void main (String args[]) {
	int number;
	int index;
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter the number");
        number = scanner.nextInt();
        
	for (index = 0; index <= number; index++){                       
	    if ((number % 2) == 0) {                
		System.out.println(index);
	    }
        }
    }
}
	     