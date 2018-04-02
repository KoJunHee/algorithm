package ass2_3;

public class ElectricPowerSwitch {
    public ISwitch iSwitch;

    public ElectricPowerSwitch(ISwitch iSwitch){
        this.iSwitch = iSwitch;
    }

    public void press(){
        if(iSwitch.isOn()){
            iSwitch.turnOff();
        }else{
            iSwitch.turnOn();
        }
    }
}




