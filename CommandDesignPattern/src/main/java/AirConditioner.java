// this is the Receiver
public class AirConditioner {

    boolean isOn;
    int temperature;

    public void setACOn(){
        this.isOn = true;
        System.out.println("AC is ON");
    }

    public void setACOff(){
        this.isOn = false;
        System.out.println("AC is OFF");
    }

    public void setTemperature(int temp){
        this.temperature = temp;
        System.out.println("AC temperature is set to : " + temperature);
    }
}
