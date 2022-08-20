import java.util.Scanner;

/**
 * This class will sort the Number of array which is in Integer
 */
class Sorter{
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int length = scanner.nextInt();
	int[] numbers = new int[length];
	int temp = 0;
	int index;
	System.out.println("Enter the numbers array"); 
	
	for (index = 0; index < length; index++) {
	    numbers[i] = scanner.nextInt();
	}
	
	// Sorting algorothm goes here
	for (index = 0; index < length; index++) {
	    if(numbers[index] > numbers[index + 1]) {
		temp = numbers[index];
		numbers[index] = numbers[index + 1];
		numbers[index + 1] =  temp;
 
	    }
	}
	
	System.out.println("The sorted numbers array is\n");
	for (int number : numbers ) {
	    System.out.println(number + " ");
	}
    }

}