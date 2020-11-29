package pl.januszsoft.carspecific.boringcommoncar;

import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.engine.RPM;

public class MaintainGear implements GearCalculator {

    @Override
    public Gear calculate(RPM rpm, Gear gear) {
        return gear;
    }
}
