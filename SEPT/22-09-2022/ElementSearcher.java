import java.util.Scanner;

/**
 * <h1> Element Searcher </h1>
 * <p> 
 * This class is used to search the Key Element
 * which given as a input to search in the Array
 * and this can be done  by using the Linear search method.
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   22-09-2022
 */
public class ElementSearcher{    
    /**
     * <h1> Element Searcher </h1>
     * <p>
     * This method will do the Linear search to find the Key Element 
     * from the given Element Array. 
     * </p>
     *
     * @param elementArray - Array of int Elements
     * @param keyElement   - the Element to be found
     * 
     * @return int         - if the key element found it will return position
     *                                           of that element otherwise -1
     */  
    public static int searchByLinearSearch(int[] elementArray, int keyElement) {  
  
        for (int index = 0; index < elementArray.length; index++) {    
            if (elementArray[index] == keyElement) {    
                return index;    
            }    
        }    
        return -1;    
    }    
 
    /**
     * <h1> Main method </h1>
     * <p>
     * This will call the searchByLinearSearch method to find the Key Element
     * from the given ElementsArray 
     * </p>
     *
     * @param args - arguments never getted
     */
    public static void main(String[] args){   
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter the no of elements: ");
        int count = scanner.nextInt();
        int[] elementsArray = new int[count];
         
        for (int index = 0; index < count; index++) {
            elemetsArray[index] = scanner.nextInt();
        }
  
        System.out.print("Enter the Element to search: ");
        int key = scanner.nextInt();    
        System.out.println(key + " is found at index: " + searchByLinearSearch(elemetsArray, key));    
    }    
}   