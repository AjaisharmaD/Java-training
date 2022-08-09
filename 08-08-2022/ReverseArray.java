import java.util.Scanner;

/* 
 * This class will reverse the int array by using the another array
 */
class ReverseArray {
    public static void main(String[] args) {
	System.out.println("Enter the no of elements to add in array");
	int no_of_elements = getInput.nextInt();
	int[] numberArray = new int[no_of_elements];
	int[] reverseArray = new int[no_of_elements];
	int iterator_i;
	int iterator_j = no_of_elements;
	
	for(iterator_i = 0; iterator_i < no_of_elements; iterator_i++){
	    reverseArray[iterator_j] = numberArray[iterator_i];				// Coping the elements in the numberArray into reverseArray
	    iterator_j = iterator_j - 1;
	}
	for(int iterator_k = 0; int iterator_k < no_of_elements; iterator_k ){
	    System.out.println(reverseArray[iterator_k]);				// printing the reverseArray
	}
    }
}