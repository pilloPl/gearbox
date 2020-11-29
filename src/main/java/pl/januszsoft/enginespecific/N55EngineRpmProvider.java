package pl.januszsoft.enginespecific;

import pl.januszsoft.engine.RPM;
import pl.januszsoft.engine.RpmProvider;

class N55EngineRpmProvider implements RpmProvider {

    private double rpm = 2000d;

    void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public RPM current() {
        return RPM.k(rpm);
    }
}
