package ass2_3;

public class Main {
    public static void main(String[] args) {

        Fan fan = new Fan();
        ElectricPowerSwitch electricPowerSwitchForFan = new ElectricPowerSwitch(fan);
        fan.turnOn();
        electricPowerSwitchForFan.press();

        LightBulb lightBulb = new LightBulb();
        ElectricPowerSwitch electricPowerSwitchForBulb = new ElectricPowerSwitch(lightBulb);
        lightBulb.turnOn();
        electricPowerSwitchForBulb.press();
    }
}
