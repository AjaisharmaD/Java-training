import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class SetExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ether the count to add the elemets: ");
        int count = scanner.nextInt();
        HashSet<String> hashSet =  new HashSet<String>();
        
        for (int index = 0; index < count; index++) {
            hashSet.add(scanner.next());
        }
        System.out.println("HashSet is: " + hashSet);
        System.out.print("enter the element to remove: ");
        hashSet.remove(scanner.next());
        System.out.println("After removed 7: " + hashSet);

        System.out.println("Size of the Set: " + hashSet.size());

        Object stringArray[] =  hashSet.toArray();
        
        for (int index = 0; index < stringArray.length; index++) {
            System.out.println((index+1) + " " + stringArray[index]);
        }
    }
} 