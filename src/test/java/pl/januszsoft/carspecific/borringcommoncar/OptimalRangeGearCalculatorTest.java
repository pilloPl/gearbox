package pl.januszsoft.carspecific.borringcommoncar;

import pl.januszsoft.carspecific.boringcommoncar.OptimalRange;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.GearRange;
import pl.januszsoft.engine.RPM;
import pl.januszsoft.engine.RpmRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptimalRangeGearCalculatorTest {

    GearRange gearRange = new GearRange(new Gear(1), new Gear(8));
    RpmRange rpmRange = RpmRange.of(RPM.k(2), RPM.k(3.5));
    OptimalRange calculator = new OptimalRange(gearRange, rpmRange);

    @Test
    void gearDown() throws Exception {
        //given
        Gear currentGear = new Gear(2);

        //when
        Gear calculated = calculator.calculate(RPM.k(1), currentGear);

        //then
        assertEquals(new Gear(1), calculated);
    }

    @Test
    void gearUp() throws Exception {
        //given
        Gear currentGear = new Gear(2);

        //when
        Gear calculated = calculator.calculate(RPM.k(4), currentGear);

        //then
        assertEquals(new Gear(3), calculated);
    }

}