import java.util.Scanner;
import java.lang.String;

class InventorySystem {
    static Scanner getInput = new Scanner(System.in);
    int noProduct;
    public String[] addProductName(String[] productName, int no_Product) {
	noProduct = no_Product;
	for(int i=0;i<noProduct; i++) {
	    getInput.nextLine();
	    String productNam = getInput.nextLine();
	    productName[i] = productNam;
	    System.out.println(i + " " + productName[i]);
	}
	return productName;
    }
    //public int[] addProductCount(int[] productCount,int noProduct){
    //int productCt =  getInput.nextInt();
	    //productCount[i] = productCt;
 	    //+ " "+ productCount[i]);
//}
    public static void main(String[] args) {
	InventorySystem sysObject = new InventorySystem();
	System.out.println("enter the no of product ");
	int no_of_product = getInput.nextInt();
	String[] productName = new String[no_of_product];
	int[] productCount = new int[no_of_product];
	String items[] = sysObject.addProductName(productName,no_of_product);
	System.out.println(items);
    }
} 
