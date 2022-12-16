public class Fan {

    // state
    private String manufacturer;
    private double radius;
    private String color;

    private boolean isOn;
    private byte speed; // 0~5

    // constructor
    public Fan(String manufacturer, double radius, String color) {
        this.manufacturer = manufacturer;
        this.radius = radius;
        this.color = color;
    }

    // isOn
    public void switchOn() {
        this.isOn = true;
        setSpeed((byte) 5);
    }

    public void switchOff() {
        this.isOn = false;
        setSpeed((byte) 0);
    }

    // speed
    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    // print the state
    public String toString() {
        return String.format("manufacturer: %s, radius: %f, color: %s, isOn: %s, speed: %d", manufacturer, radius, color, isOn, speed);
    }
}
