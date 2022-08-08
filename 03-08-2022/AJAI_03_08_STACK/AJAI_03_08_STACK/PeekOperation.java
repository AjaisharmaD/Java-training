import java.util.Stack;
import java.util.Scanner;

public class PeekOperation extends SearchOperation {
    Scanner scan = new Scanner(System.in);
    
    void stackPeek(Stack<Integer> stack) {
	Integer element = (Integer) stack.peek();
	System.out.println("Element at the top of the stack is "+element);
    }
}