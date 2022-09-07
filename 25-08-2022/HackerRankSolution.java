/**
 * Adding the Strings Length
 * Checks whether the first string lexicographically greater then Second String
 * Change the first letter of the String in capital and add them with a space between
 *
 * @author Ajaisharma D
 */
public class HackerRankSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();
        
        System.out.println(firstString.length() + secondString.length());
        
        if (firstString.compareTo(secondString) > 0) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }

        firstString =  firstString.substring(0,1).toUpperCase() + firstString.substring(1);
        secondString =  secondString.substring(0,1).toUpperCase() + secondString.substring(1);
        System.out.println(firstString + " " + secondString);
    }
}