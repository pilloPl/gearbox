package pl.januszsoft.carspecific.boringcommoncar;

import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.engine.RPM;
import pl.januszsoft.engine.RpmRange;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.GearRange;

public class OptimalRange implements GearCalculator {

    private final GearRange range;
    private final RpmRange optimalRange;

    public OptimalRange(GearRange range, RpmRange optimalRange) {
        this.range = range;
        this.optimalRange = optimalRange;
    }

    @Override
    public Gear calculate(RPM currentRpm, Gear currentGear) {
        Gear gear = calculateGear(currentRpm, currentGear);
        return range.trim(gear);
    }

    private Gear calculateGear(RPM currentRpm, Gear currentGear) {
        if (currentRpm.isBelow(optimalRange)) {
            return currentGear.previous();
        } else if (currentRpm.isAbove(optimalRange)) {
            return currentGear.next();
        } else {
            return currentGear;
        }
    }

}


