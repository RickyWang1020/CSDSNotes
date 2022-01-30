package basic_interface;

public class Car implements Vehicle{

    private int gear = 3;
    private int speed = 0;

    public void changeGear(int gear) {
        this.gear = gear;
    }

    public void speedUp(int var) {
        this.speed += var;
    }

    public void slowDown(int var) {
        this.speed -= var;
    }

    public void display() {
        System.out.println("gear is " + this.gear + ", speed is " + this.speed);
        out();
    }

}
