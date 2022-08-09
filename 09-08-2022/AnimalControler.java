class Animal {
    String name;			lass
    public void work() {
        System.out.println("I will eat pedigree");
    }
}

/* this is a subclass whis was inherited from Animal */
class Dog extends Animal {		    	
    public void displayName() {		
        System.out.println("My name is " + name);
    }
}

public class AnimalControler {
    public static void main (String[] args) {
        Dog breed = new Dog();		
        breed.name = "Labradore";	
        breed.displayName();
        breed.work();			        				
    }
}