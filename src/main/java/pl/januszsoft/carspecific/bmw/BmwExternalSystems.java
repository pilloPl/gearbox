package pl.januszsoft.carspecific.bmw;

public class BmwExternalSystems {

    private double currentRpm = 10d;
    private double angularSpeed = 150;
    private Lights lights = new Lights();
    private Characteristics characteristics = new Characteristics();

    public BmwExternalSystems() {
    }

    public double angularSpeedForDrifting() {
        return characteristics.angularSpeedForDrifting();
    }

    public void setCurrentRpm(double currentRpm) {
        this.currentRpm = currentRpm;
    }

    public double getAngularSpeed() {
        return angularSpeed;
    }

    public void setAngularSpeed(double angularSpeed) {
        this.angularSpeed = angularSpeed;
    }

    public Lights getLights() {
        return lights;
    }
}
