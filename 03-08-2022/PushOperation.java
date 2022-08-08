import java.util.Stack;
import java.util.Scanner;

public class PushOperation extends PopOperation {
    Scanner scan = new Scanner(System.in);
    void stackPush(Stack<Integer> stack) {
        System.out.println("enter the number of elements to push");
        int noElements = scan.nextInt();

	for (int i=0; i<noElements; i++) {
	    stack.push(i);
	}
	System.out.println(stack);
    }
}