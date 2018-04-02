package ass2_3;

public class Fan implements ISwitch {

    public boolean on;
    public void turnOn() {
        System.out.println("Fan: Fan turned on...");
        on =true;
    }
    public void turnOff() {
        System.out.println("Fan: Fan turned off...");
        on =false;
    }
    public boolean isOn() {
        return this.on;
    }
}



