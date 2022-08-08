import java.util.Scanner;

class Calculators {
    public static void main (String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the inputs to do calculations");
	int inputNumber1 = scan.nextInt();
	int inputNumber2 = scan.nextInt();
	System.out.println("Enter the Operator to do Calculation");
	char choice = scan.next().charAt(0);

	switch(choice) {
	case '+':
	    int addition = inputNumber1 + inputNumber2;
	    System.out.println("Addition of two numbers is " + addition);
	    break;

	case '-':
	    int subtraction = inputNumber1 - inputNumber2;
	    System.out.println("Subtaction of two numbers is " + subtraction);
	    break;

	case '*':
	    int multiplication = inputNumber1 * inputNumber2;
	    System.out.println("Suntaction of two numbers is " + multiplication);
	    break;

	case '/':
	    int division = inputNumber1 / inputNumber2;
	    System.out.println("Suntaction of two numbers is " + division);
	    break;
	}
    }
}