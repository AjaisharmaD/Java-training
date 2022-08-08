import java.util.Stack;
import java.util.Scanner;

public class SearchOperation {
 
    Scanner scan = new Scanner(System.in);
    void stackSearch(Stack<Integer> stack) {
	
	System.out.println("enter the element to search");
	Integer searchElement = scan.nextInt();
	Integer element = (Integer) stack.search(searchElement);
	
	if(element == -1)
	    System.out.println("The Stack is empty");
	else
	    System.out.println("Element at the top of the stack is "+element);
    }
}