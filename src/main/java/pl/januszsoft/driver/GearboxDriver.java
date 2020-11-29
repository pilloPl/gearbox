package pl.januszsoft.driver;

import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.driver.calculator.GearCalculators;
import pl.januszsoft.engine.RpmProvider;
import pl.januszsoft.driver.shifter.Shifter;

class GearboxDriver {

    enum DriverState {
        Reverse, Neutral, Park, Drive
    }

    private final RpmProvider rpmProvider;
    private final Shifter shifter;
    private final GearCalculators gearCalculators;
    private DriverState state = DriverState.Park;

    GearboxDriver(RpmProvider rpmProvider, Shifter shifter, GearCalculators gearCalculators) {
        this.rpmProvider = rpmProvider;
        this.shifter = shifter;
        this.gearCalculators = gearCalculators;
    }

    void enableDrive() {
        state = DriverState.Drive;
    }

    void enablePark() {
        state = DriverState.Park;
    }

    void enableNeutral() {
        state = DriverState.Neutral;
    }

    void recalculate() {
        if (state == DriverState.Drive) {
            Gear newGear = suggestedGear();
            shifter.changeGearTo(newGear);
        }
    }

    Gear suggestedGear() {
        GearCalculator gearCalculator = gearCalculators.suggest();
        return gearCalculator.calculate(rpmProvider.current(), shifter.currentGear());
    }

}


