/* Chef wants to become fit for which he decided to walk to the office and return home by walking. 
 * It is known that Chef's office is X km away from his home.

 *If his office is open on 5 days in a week, find the number of kilometers Chef travels through office trips in a week.
 */
class Fitness {
    public static void main (String[] args) {
	Scanner getInput= new Scanner(System.in);
	int n=getInput.nextInt();
	int distance;
	int totalDistance;
	for(int i=0;i<n;i++) {
	    distance=sc.nextInt();
	    distance = distance + distance;
	    totalDistance = distance * 5;
	    System.out.println("number of kilometers Chef travels through office trips in a week " + totalDistance);
	}
    }
}