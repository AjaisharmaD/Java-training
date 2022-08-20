/**
 * This program prints the Pyramid pattern of a star
 */

import java.util.Scanner;

public class PyramidPattern {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int index1;
	int index2;
	int row = scanner.nextInt();

	for (index1 = 0; index1 < row; index1++) {
	    for (index2 =  row - 1; index2 > 1; index2--) {
		System.out.print(" ");
	    }
	}
	
	for (index2 = 0; index2 <= index1; index2++) {
	    System.out.print("*");	
	}
    }
}