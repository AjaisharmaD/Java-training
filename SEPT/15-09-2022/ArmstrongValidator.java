import java.util.Scanner;

/**
 * This finds the given number is Armstrong number or not
 */
public class ArmstrongValidator {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int number = scanner.nextInt();
        int numberLength = number.length();
        int originalNumber;
        int remainder;
        int result = 0;

        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, numberLength);
            originalNumber /= 10;
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");
    }
}