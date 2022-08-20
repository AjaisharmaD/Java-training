/**
 * Program implemets the string methods
 * @author Ajaisharma D
 * version 1.0  20-08-2022
 */
import java.util.Scanner;

/**
 * <h> StringMethod </h>
 * <p> Class contains the methods to find length of name
 * combining the first and second names
 * comparing the two names  are equal or not and 
 * a main method which call and implemets all the methods</p>
 */
public class StringMethod {
    /**
     * <h>Find Length</h>
     * <p> findLength method calculates the length of the name </p>
     * @param {@link String} name
     * @return {@link int} scope
     */
    public static int findLength(String name) {
        int scope = name.length();
        return scope;
    }
    
    /**
     * <h>Comine Name</h>
     * <p> combinename method concadinates the two names
     * concadinating the second name at the end of first name </p>
     * @param {@link String} name1
     * @param {@link String} name2
     * @return {@link String} combine
     */
    public static String combineName(String name1, String name2) {
        String combine = name1.concat(name2);
        return combine;
    }
    
    /**
     * <h>Comine Name</h>
     * <p> combinename method concadinates the two names
     * concadinating the second name at the end of first name </p>
     * @param {@link String} name1
     * @param {@link String} name2
     * @return {@link boolean} isEqual
     */
    public static boolean checkEqual(String name1, String name2) {
        boolean isEqual = name1.equals(name2);
        return isEqual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

	System.out.println("==========Length of the Strings are==========\n");
        System.out.println("Length of the First Name " 
                               + findLength(firstName) + "\n");
        System.out.println("Length of the Second Name " 
                               + findLength(secondName)+ "\n");

        System.out.println("==========Concadinating the Strings==========\n");
        System.out.println("Concadinated String " 
                               + combineName(firstName, secondName) + "\n");

        System.out.println("========== Comparing two Names==========");
        System.out.println("Checked that two Names are Eaqual " 
                               + checkEqual(firstName, secondName) + "\n");

        System.out.println("=====This is a Escape" 
                               + "Character in Java String=====\n");
        System.out.println("This is a \"How Escape character is working\"!");
    }
}