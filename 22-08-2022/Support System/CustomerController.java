public class CustomerController {
    System.out.print("Enter the Name : ");
        records.setName(scanner.nextLine());
        System.out.print("Enter the Phone Number : ");
        records.setPhoneNumber(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Enter the Email ID : ");
        records.setEmail(scanner.nextLine());
        System.out.print("Enter the Address : ");
        records.setAddress(scanner.nextLine());

        System.out.println("name : " + records.getName());
        System.out.println("PhoneNumber : " + records.getPhoneNumber());
        System.out.println("Email ID : " + records.getEmail());
        System.out.println("Address : " + records.getAddress());
}