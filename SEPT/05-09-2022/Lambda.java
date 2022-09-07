import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeList =  new ArrayList<>();
        System.out.println("Enter the count: ");
        int count = scanner.nextInt();

        for (int index = 0; index <= count; index++) {
            System.out.println("Enter the name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the Salary: ");
            int salary = scanner.nextInt();
            System.out.println("Enter the Experience: ");
            int experience = scanner.nextInt();

            employeeList.add(new Employee(name, salary, experience));
        }
        //function_interface
        Function<Integer, Integer> function = employee -> (employee.salary * 10) / 100;
        //predicate_interface
        Predicate<Integer> predicate =  bonus -> bonus >= 5000;

        //Consumer
        Consumer<Employee> consumer = employee -> {
             System.out.println("name: " + employee.name + "\nSalary :" + salary + "\nExperience: " + experience);
        };

        for (Employee employee : employeeList) {
            int bonus = function.apply(employee);

            if (predicate.test(bonus)) {
                consumer.accept(employee);
                System.out.println(bonus);  
            }
        }

        Supplier<Date> supplier = new Date();

        System.out.println("Today's Date is: " + supplier.get());
    }
}