class CarEngine {
    boolean start = false;
    public boolean startEngine() {
	start = true;
	return start;
    }

    public boolean stopEngine() {
	return start;
    }
}

class Car {
    private String carBrand;
    private int topSpeed;

    public void printCarDetails() {
	System.out.println(" Car Brand = " + carBrand+ " Top Speed = " +topSpeed );
    } 

    public void setBrand(String brand) {
	carBrand = brand;
    }

    public void setTopSpeed(int speed) {
	topSpeed = speed;
    }
}

class Honda extends Car {
    public void startHonda() {
	CarEngine engine = new CarEngine();
	System.out.println(engine.startEngine());
    }
}

public class Composition {
    public static void main(String[] args) {
        Honda honda = new Honda();
	honda.setBrand("Honda");
	honda.setTopSpeed(180);
	honda.printCarDetails();
	honda.startHonda();
    }
}