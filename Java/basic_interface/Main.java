package basic_interface;

public class Main {
    public static void main(String[] args) {
        // use static method
        System.out.println(Vehicle.plus_nine(8));

        Car ford = new Car();
        ford.speedUp(4);
        ford.changeGear(10);
        ford.display();
    }
}
