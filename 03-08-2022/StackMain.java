import java.util.Stack;
import java.util.Scanner;

class StackMain extends PushOperation{
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	StackMain Obj = new StackMain();
	
	Stack<Integer> stack = new Stack<Integer>();
	Obj.stackPush(stack);
	Obj.stackPop(stack);
	Obj.stackPeek(stack);
	Obj.stackSearch(stack);
    }
}