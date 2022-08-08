import java.util.Stack;
import java.util.Scanner;

public class PopOperation extends PeekOperation {
    Scanner scan = new Scanner(System.in);
    
    void stackPop(Stack<Integer> stack) {
	System.out.println("enter the number of elements to pop");
        int noElements = scan.nextInt();

    	for (int i=0; i<noElements; i++) {
	    stack.pop();
	}
	System.out.println("after poping the element from stack "+stack);
    }
}