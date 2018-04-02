package ass2_3;

public class LightBulb implements ISwitch {

    public boolean on;
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned on...");
        on =true;
    }
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned off...");
        on =false;
    }
    public boolean isOn() {
        return this.on;
    }
}



