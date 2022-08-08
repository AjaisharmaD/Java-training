import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

class ArrayListExecution {
    public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);

	System.out.println("enter the number of Input to add in Array List");
	int n = scan.nextInt();
	int position;
	String element;

	ArrayList<String> stringArray = new ArrayList<String>(n);

	scan.nextLine();							// used to return the input which is skipped
	for(int i=0; i<n; i++) {
	    element = scan.nextLine();
	    stringArray.add(i,element);
	}
	System.out.println("\narray list after adding elemets"+stringArray+"\n");

	System.out.println("\nenter your choice to performthe following operation \n1.Change \n2.Remove \n3.Get element \n4.IsEmpty \n");
	int choice = scan.nextInt();
	
	switch(choice) {
	case 1:
	    System.out.println("\nenter the postion and element to change\n");
	    position = scan.nextInt();
	    element = scan.nextLine();
	    stringArray.set(position,element);
	    System.out.println("\nArray List after replaceing the elament "+stringArray);
	    break;

	case 2:
	    System.out.println("\nenter the position to remove the element\n");
	    position = scan.nextInt();
	    stringArray.remove(position);
	    System.out.println("\nAfter removing one element from Array List "+stringArray);
	    break;

	case 3:
            System.out.println("\nenter postion to get the element\n");
	    position = scan.nextInt();
	    System.out.println(stringArray.get(position)+"is present at the position number "+position);
	    break;

	case 4:
	    boolean result = stringArray.isEmpty();
	    if(result == true)
	        System.out.println("\nThe String Array is empty\n");
	    else
	        System.out.println("\nThe String Array is not empty\n");
	    break;

	default:
	    System.out.println("\nYou have entered the wrong choice please give the correct choice mentioned above\n");
	}
	
	Iterator iterate = stringArray.iterator();
	
	while(iterate.hasNext()) {
	    System.out.println(iterate.next());
	}
    }
}
