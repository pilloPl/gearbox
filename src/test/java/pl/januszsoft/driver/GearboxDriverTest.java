package pl.januszsoft.driver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.januszsoft.carspecific.boringcommoncar.OptimalRange;
import pl.januszsoft.driver.calculator.GearCalculators;
import pl.januszsoft.driver.shifter.Shifter;
import pl.januszsoft.engine.RPM;
import pl.januszsoft.engine.RpmProvider;
import pl.januszsoft.engine.RpmRange;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

class GearboxDriverTest {

    @InjectMocks
    GearboxDriver driver;

    @Mock
    GearCalculators gearCalculators;

    @Mock
    Shifter shifter;

    @Mock
    RpmProvider rpmProvider;

    @BeforeEach
    public void setup() {
        rpmProvider = Mockito.mock(RpmProvider.class);
        shifter = Mockito.mock(Shifter.class);
        gearCalculators = Mockito.mock(GearCalculators.class);

        driver = new GearboxDriver(rpmProvider, shifter, gearCalculators);
    }

    @Test
    void should_not_shit_in_park_mode() {
        //given
        driver.enablePark();

        //when
        driver.recalculate();

        //then
        verifyZeroInteractions(shifter);
    }

    @Test
    void should_not_shit_in_neutral_mode() {
        //given
        driver.enableNeutral();

        //when
        driver.recalculate();

        //then
        verifyZeroInteractions(shifter);
    }

    @Test
    void should_shift_to_recalculated_gear_in_drive_mode_and_optimal_range_calculator() {
        //given
        driver.enableDrive();
        //and
        currentRPMis(RPM.k(4));
        //and
        currentGearIs(new Gear(4));

        //and
        optimalRangeCalculatorIsUsedWithRanges(eightGears(), RpmRange.of(RPM.k(2), RPM.k(3.5)));

        //when
        driver.recalculate();

        //then
        shifterWasAskedToChangeTo(new Gear(5));
    }

    void shifterWasAskedToChangeTo(Gear gear) {
        Mockito.verify(shifter).changeGearTo(gear);
    }

    GearRange eightGears() {
        return new GearRange(new Gear(1), new Gear(8));
    }

    void optimalRangeCalculatorIsUsedWithRanges(GearRange gearRange, RpmRange optimalRpmRange) {
        when(gearCalculators.suggest()).thenReturn(new OptimalRange(gearRange, optimalRpmRange));
    }

    void currentGearIs(Gear currentGear) {
        when(shifter.currentGear()).thenReturn(currentGear);
    }


    void currentRPMis(RPM rpm) {
        when(rpmProvider.current()).thenReturn(rpm);
    }

}