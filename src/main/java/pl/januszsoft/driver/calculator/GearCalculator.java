package pl.januszsoft.driver.calculator;

import pl.januszsoft.driver.Gear;
import pl.januszsoft.engine.RPM;

//abstract product
public interface GearCalculator {

    Gear calculate(RPM rpm, Gear current);

}
