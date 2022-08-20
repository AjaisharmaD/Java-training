/*
 *Program to find the number is palindrome or not
 */
import java.util.Scanner;

class Palindrome {
    public static void main(String[] args) {
        int remainder;
        int number;
        int sum = 0;
        int temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        number = scanner.nextInt();
        temp = number; 

        while (number > 0) {
	    remainder = number % 10;
	    sum = (sum * 10) + remainder;
	    number = number / 10;
        }

        if (temp == sum){                                   
            System.out.println("Number is Palindrome");
        } else {
	    System.out.println("Number is not Palindrome");
        }
    }
}