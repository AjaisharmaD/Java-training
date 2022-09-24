import java.util.Set;
import java.util.HashSet;

/**
 * Finds the Intersection of two set and prints it
 */
class SetIntersectionFinder {
    public static void main(String[] args) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        Set<Integer> intersectionOfSet = new HashSet<>();

        System.out.print("Enter the number of elements to add in first Set: ");
        int firstCount = scanner.nextInt();
        System.out.print("Enter the Elements: ");        
        
        for (int index = 0; index < count; index++) { 
            firstSet.add(scanner.nextInt());
        }

        System.out.println("First SET: " + firstSet);

        System.out.print("Enter the number of elements to add in second Set: ");
        int secondCount = scanner.nextInt();
        System.out.print("Enter the Elements: ");        
        
        for (int index = 0; index < secondCount; index++) { 
            secondSet.add(scanner.nextInt());
        }
        System.out.println("Second SET: " + secondSet);

        intersectionOfSet = findIntersection(firstSet, secondSet);

        System.out.println("Intersection of two Sets: " + unionOfSet);
    }

    /**
     * Finds the Intersection of two 
     *
     * @param firstSet - first set for union operation
     * @param secondSet - second set for union operation
     * @return Union set of two sets
     */
    public Set<Integer> findIntersection(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
        return secondSet.retainAll(firstSet);
    }
}