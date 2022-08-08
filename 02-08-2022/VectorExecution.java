import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;

class VectorExecution {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	System.out.println("Enter the number of elements to add elements");

	int noElement = scan.nextInt();
	int position;
	String element;
	int i;

	Vector<String> vector = new Vector<String>(); 

	ArrayList<String> arrayList = new ArrayList<String>();
	scan.nextLine();
	for(i=0; i<noElement; i++) {
	        arrayList.add(scan.nextLine());
	    }

	int list[] = {1,2,3,4,5,6,7,8};
	System.out.println("Enter the number to perfor the operations in vector List \n 1.add\n 2.addall \n 3.add element at position\n 4.capacity\n 5.copy Into\n                                       6.get the element by position\n 7.remove element at position\n 8.clear");
	int choice = scan.nextInt();

	
	    while(choice <= list.length) {
	        switch(choice) {
	        case 1:
	            System.out.println("Enter the number of elements to add elements");
	            noElement = scan.nextInt();
		    scan.nextLine();
                    for(i=0; i<noElement; i++) {
	                vector.add(scan.nextLine());
	            }
		    System.out.println(vector);
	            break;

                case 2:
	            vector.addAll(arrayList);

	            System.out.println("after adding array list in vector list"+vector);
	            break;

	        case 3:
		    System.out.println("enter the position and element to add to vector list");
		    position = scan.nextInt();
		    element = scan.nextLine();

		    vector.add(position, element);
		    System.out.println("Vector list After adding an element"+vector);	
		    break;

	        case 4:
		    System.out.println("the capacity of Vector list is"+vector.capacity());
		    break;

	        case 5:
		    int l = vector.size();
		    System.out.println("Copy the Vector List into the array");
		    String arr[] = new String[l];

		    vector.copyInto(arr);
		    
		    for(String j: arr)
		        System.out.println(j);
		
		    break;

		case 6:
		    System.out.println("Get the element by its position");
		    System.out.println("enter the position to get the element");
		    position = scan.nextInt();
		    vector.get(position);
		    break;

		case 7:
		    System.out.println("Remove the element by its postion.. \n enter the postion to remove the element ");
		    position = scan.nextInt();
		    vector.get(position);
		    System.out.println("Vector list after removed the element"+vector);
		    break;

		case 8:
		    vector.clear();
		    System.out.println("Vector List is cleared");
		    break;
		}    
	    }
	
    }
}