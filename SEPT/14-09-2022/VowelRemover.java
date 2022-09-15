import java.util.Scanner;
/**
 * Reads he String input 
 * Removes the Vowels within the string
 * Prints the new String
 */
public class VowelRemover {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String sentance = scanner.nextLine();
        String newSentance = removeVowel(sentance);

        printModifiedString(newSentance);
    }

   /**
    * Removes the Vowels within the given Sentance
    */
    public static String removeVowel(String sentance) {
    
        for (int position = 0; position < sentance.length(); position++) {
            if (sentance.charAt(position) == 'a' || sentance.charAt(position) == 'e'
                || sentance.charAt(position) == 'i' || sentance.charAt(position) == 'o' 
                || sentance.charAt(position) == 'u') {
                continue;
            }
         System.out.println(sentance);
        }
        return sentance;
    }

    public static void printModifiedString(String newSentance) {
        System.out.println(newSentance);
    }
}