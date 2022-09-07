/**
 * Prints a sub string from the String
 */
public Class HackerRank {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int start = scanner.nextInt();
        int end = scanner.nextInt(); 
        System.out.println(string.substring(start,end));
    }
}