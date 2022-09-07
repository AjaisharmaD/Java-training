/**
 * implements the Iterator Interface
 * 
 * @author Ajaisharma D
 */
public class IteratorExecutor {
     public static void main() {
         List<Integer> list = new List<Integer>();
         list.add(3);
         list.add(5);
         list.add(6);
         list.add(8);
         
         Iterator<Integer> iterator = list;

         while (iterator.hasNext()) {
             System.out.println(iterator.next());
         }
     }
}