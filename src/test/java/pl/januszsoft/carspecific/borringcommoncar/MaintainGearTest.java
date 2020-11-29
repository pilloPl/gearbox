package pl.januszsoft.carspecific.borringcommoncar;

import org.junit.jupiter.api.Test;
import pl.januszsoft.carspecific.boringcommoncar.MaintainGear;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.engine.RPM;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaintainGearTest {

    GearCalculator maintainGear = new MaintainGear();

    @Test
    void shouldMaintainGear() {
        assertEquals(new Gear(4), maintainGear.calculate(RPM.k(20), new Gear(4)));
        assertEquals(new Gear(4), maintainGear.calculate(RPM.k(20), new Gear(4)));
        assertEquals(new Gear(4), maintainGear.calculate(RPM.k(20), new Gear(4)));
        assertEquals(new Gear(4), maintainGear.calculate(RPM.k(20), new Gear(4)));
    }

}