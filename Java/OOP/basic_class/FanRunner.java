public class FanRunner {
    public static void main(String[] args) {
        Fan fan = new Fan("manu1", 0.123, "RED");
        System.out.println(fan); // manufacturer: manu1, radius: 0.123000, color: RED, isOn: false, speed: 0
        fan.switchOn();
        System.out.println(fan); // manufacturer: manu1, radius: 0.123000, color: RED, isOn: true, speed: 5
        fan.setSpeed((byte) 15);
        System.out.println(fan); // manufacturer: manu1, radius: 0.123000, color: RED, isOn: true, speed: 15
        fan.switchOff();
        System.out.println(fan); // manufacturer: manu1, radius: 0.123000, color: RED, isOn: false, speed: 0
    }
}
