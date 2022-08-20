import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeConvertor {
     public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
         String s= sc.nextLine();
         DateFormat format1 = new SimpleDateFormat("hh:mm:ssa");
         DateFormat format2 =  new SimpleDateFormat("HH:mm:ss");
         Date date = date1.parse(s);
         System.out.println(odf.format(date));    
     }
}