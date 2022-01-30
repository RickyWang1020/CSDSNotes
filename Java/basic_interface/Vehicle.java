package basic_interface;

public interface Vehicle {

    final int gears = 5;

    // we have to define the functions inside the implemented Java classes!
    void changeGear(int a);
    void speedUp(int a);
    void slowDown(int a);

    // default method: there is no need to specify the default method, it will automatically be implemented
    // good if we want every implemented class to have this method
    default void out() {
        System.out.println("this is default");
    }

    // static method: even if we haven't created the instance, we can still use the static methods
    static int plus_nine(int x) {
        return x + 9;
    }
}
