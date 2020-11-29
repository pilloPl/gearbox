package pl.januszsoft.carspecific.bmw.calculator;

import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.engine.RPM;
import pl.januszsoft.engine.RpmRange;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.GearRange;

//todo test
class DoubleKickdown implements GearCalculator {

    private final GearRange range;
    private final RpmRange optimalRange;

    DoubleKickdown(GearRange range, RpmRange optimalRange) {
        this.range = range;
        this.optimalRange = optimalRange;
    }

    @Override
    public Gear calculate(RPM rpm, Gear current) {
        if (rpm.isAbove(optimalRange.leftHalf())) {
            return current.previous().previous();
        } else if (!rpm.isAbove(optimalRange)) {
            return current.previous();

        } else {
            return current; //todo trim?
        }
    }
}
