/*
 * Chef is fond of burgers and decided to make as many burgers as possible.
 * Chef has patties and buns. To make 1 burger, Chef needs 1 patty and 1 bun.
 * Find the maximum number of burgers that Chef can make.
 *
 * INPUT	OUTPUT
 * 4		   
 * 2 2		   2
 * 2 3		   2
 * 3 2		   2
 * 23 17  	   17
 *
 * Here I am checking the buns and patties count 
 * if any of those count is less than the others then that much burgers only chef can make 
 */
class BurgerPatty{
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int numberOfCombinations;				//getting the combination from the user 
	int patties;
	int buns;
	int burgers;
	System.out.println("Enter the combination of patties and buns");
	numberOfCombinations = scanner.nextInt();

	for(int i=0;i<numberOfCombinations;i++) {
	    System.out.println("Enter the number of patties");
	    patties = scanner.nextInt();			// no of patties to make burger
	    System.out.println("Enter the number of buns");
	    buns=scanner.nextInt();				// no of buns to make burger

	    if(patties>buns)
		burgers = buns;
	        System.out.println(burgers);
	    else if(patties<buns)
		burgers = patties;
		System.out.println(burgers);
	    else if(patties==buns)
		burgers = patties;
		System.out.println(burgers);
	}
    }
}