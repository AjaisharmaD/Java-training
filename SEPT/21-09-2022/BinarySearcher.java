import java.util.Scanner;

/**
 * This finder will get the element from te given array by searching
 * the Key Element
 *
 * @author Ajaisharma D
 * @version 1.0 
 * @since 24-08-2022
 */
public class BinarySearcher {  
    
    /**
     * This method will find and prints the key elemet
     */
    public static void searchElement(int arrayElements[], int firstElement,
                                    int lastElement, int keyElement) {  
        int middleElement = (firstElement + lastElement)/2;  
        
        while (first <= last) {  
            if (arr[middleElement] < key) {  
                firstElement = middleElement + 1;     
            } else if (arr[middleElement] == keyElement) {  
                System.out.println("Element is found at index: "
                                               + middleElement);  
                break;  
            } else {  
                lastElement = middleElement - 1;  
            }  
        middleElement = (firstElement + lastElement)/2;  
        }
  
        if (firstElement > lastElement) {  
            System.out.println("Element is not found!");  
        }  
    } 
 
    public static void main(String args[]) {  
        Scanner scanner = new Scanner(System.in);
        int arrayElement[] = {10,20,30,40,50};  
        int keyElement = scanner.nextInt();  
        int lastElement = arrayElements.length-1;  
        searchElement(arrayElements, 0, lastElement, keyElement);     
    }  
}  