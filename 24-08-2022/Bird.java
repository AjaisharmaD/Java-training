/**
 * contains the walk method 
 * @version 1.0 24-08-2022
 */
class Animal{
    void walk(){
        System.out.println("I am walking");
    }
}

/**
 * contains the method that bird can do  
 * @version 1.0 24-08-2022
 */
class Bird extends Animal{
    void fly(){
        System.out.println("I am flying");
    }
    
    void walk() {
        System.out.println("I am walking");
    }
    
    void sing() {
        System.out.println("I am singing");
    }
}