import java.util.Scanner;

class LeftRotator{
    public static void main(String[] args) {
	int length = scanner.nextInt();
	int[] numbers = new int[length];
	int rotation = scanner.nextInt();
	
	for (int index =  0 ; index < length; index++) {
	    numbers[index] = scanner.nextInt();
	}

	for (int index = 0; index < rotation; index++) {
	    int index1;
	    int firstElement;
	    
	    for(index1 =0; index < length - 1; index1++) {
		numbers[index1] = numbers[index1 + 1];
	    }
	    
	    number[index1] = firstElement;
	}    
	System.out.println("The Rotated Array");
	for (int number: numbers) {
	    System.out.println(number + " ");
	}
	
    }
}