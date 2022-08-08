import java.util.Scanner;
import java.util.LinkedList;

class LinkedListExecution {
    public static void main(String[] args) {
	int check;
	int position;
        int element;
	Scanner scan = new Scanner(System.in);

	System.out.println("enter the number of Input element");
	int n = scan.nextInt();
		
	LinkedList<Integer> linkList = new LinkedList<Integer>();

	for(int i=0; i<n; i++) {
	    linkList.add(scan.nextInt());
	}
	
	int j=1;

        while (j!=0) {
            System.out.print("Do you want to Perform the Funtion Enter 1 for changes 2 for remove 3 for Exit....");
            check = scan.nextInt();
            
            switch(check) {
            case 1:
                System.out.print("Enter which element position need to be changed :");
                position = scan.nextInt();
                
                System.out.print("Enter the new element for that position :");
                element =scan.nextInt();
                linkList.set(position,element);
                System.out.println(linkList);
                break;
        
            case 2:  
                System.out.print("Enter which element need to be removed :");
                
                linkList.remove(scan.nextInt());
                System.out.println(linkList);
                break;

            case 3:
                j=0;
                break;
            }
	}   
    }
}