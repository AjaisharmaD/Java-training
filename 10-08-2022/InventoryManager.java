import java.util.Scanner;

class InventoryManager {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	DetailsRecorder records = new DetailsRecorder();
	System.out.println("Enter the product Id");
	int id = scanner.nextInt();
	records.setProductId(id);
	System.out.println(records.getProductId());
    } 
}