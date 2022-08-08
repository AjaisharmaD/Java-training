import java.util.Scanner;

public class Timer {
    public static void main(String args[]) {
	Scanner getInput = new Scanner(System.in);
	System.out.println("enter the numeber of iterations");
	int numberOfIteration = getInput.nextInt();
	int i;
	// for For loop
        long startTimeFor = System.nanoTime();
        for(i=0; i<numberOfIteration; i++);

        long elapsedTimeFor = System.nanoTime() - startTimeFor;
        System.out.println(elapsedTimeFor);
	// for While loop
	i = 0;
	long startTimeWhile = System.nanoTime();
        while(i<numberOfIteration){
            i++;
        }

        long elapsedTimeWhile = System.nanoTime() - startTimeWhile;
        System.out.println(elapsedTimeWhile);
    }      
}


/* --------------------OUTPUT------------------
C:\Users\LENOVO\Desktop\AUGEST\06-08-2022>javac Timer.java

C:\Users\LENOVO\Desktop\AUGEST\06-08-2022>java Timer
enter the numeber of iterations
465748364
5872300
100
*/