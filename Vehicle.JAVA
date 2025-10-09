// File: VehicleDemo.java

// Base class
class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void displayInfo() {
        System.out.println("Vehicle Brand: " + brand);
    }
}

// Derived class
class Car extends Vehicle {
    int speed;

    Car(String brand, int speed) {
        super(brand); // calling parent constructor
        this.speed = speed;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // calling parent method
        System.out.println("Car Speed: " + speed + " km/h");
    }
}

// Further derived class
class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int speed, int batteryCapacity) {
        super(brand, speed); // calling Car constructor
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // calling Car's displayInfo()
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Main class
public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Generic Vehicle");
        Car c = new Car("Toyota", 180);
        ElectricCar e = new ElectricCar("Tesla", 250, 85);

        System.out.println("--- Vehicle Details ---");
        v.displayInfo();

        System.out.println("\n--- Car Details ---");
        c.displayInfo();

        System.out.println("\n--- Electric Car Details ---");
        e.displayInfo();
    }
}
