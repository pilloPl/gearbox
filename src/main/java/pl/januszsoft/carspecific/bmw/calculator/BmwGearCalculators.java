package pl.januszsoft.carspecific.bmw.calculator;

import pl.januszsoft.carspecific.bmw.BmwExternalSystems;
import pl.januszsoft.carspecific.bmw.Characteristics;
import pl.januszsoft.carspecific.boringcommoncar.MaintainGear;
import pl.januszsoft.carspecific.boringcommoncar.OptimalRange;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.GearRange;
import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.driver.calculator.GearCalculators;
import pl.januszsoft.driver.shifter.Shifter;

//concrete factory (bmw)
class BmwGearCalculators implements GearCalculators {

    enum DriveMode {
        Eco, Comfort, Sport
    }

    private DriveMode mode = DriveMode.Comfort;
    private final Characteristics characteristics;
    private final Shifter shifter;
    private final BmwExternalSystems bmwExternalSystems;
    private boolean mDynamics;
    private AggresiveLevel aggresiveLevel = AggresiveLevel.First;
    private boolean kickedDown;

    BmwGearCalculators(Characteristics characteristics, Shifter shifter, BmwExternalSystems bmwExternalSystems) {
        this.characteristics = characteristics;
        this.shifter = shifter;
        this.bmwExternalSystems = bmwExternalSystems;
    }

    @Override
    public GearCalculator suggest() {
        if (isDrifting()) {
            return new MaintainGear();
        }

        if (mode == DriveMode.Eco) {
            return new OptimalRange(gearRange(), characteristics.optimalEcoRpmRange());
        }

        if (mode == DriveMode.Comfort) {
            if (kickedDown) {
                return new Kickdown(gearRange(), aggresiveLevel.modify(characteristics.optimalComfortRpmRange()));
            } else {
                return new OptimalRange(gearRange(), aggresiveLevel.modify(characteristics.optimalComfortRpmRange()));
            }
        }

        if (mode == DriveMode.Sport) {
            if (kickedDown) {
                return new DoubleKickdown(gearRange(), aggresiveLevel.modify(characteristics.optimalSportRpmRange()));
            } else {
                return new OptimalRange(gearRange(), aggresiveLevel.modify(characteristics.optimalSportRpmRange()));
            }
        }

        return new OptimalRange(gearRange(), aggresiveLevel.modify(characteristics.optimalComfortRpmRange()));
    }

    void ecoMode() {
        mode = DriveMode.Eco;
    }

    void comfortMode() {
        mode = DriveMode.Comfort;
    }

    void sportMode() {
        mode = DriveMode.Sport;
    }

    void enableMDynamics() {
        this.mDynamics = true;
    }

    void disableMDynamics() {
        this.mDynamics = false;
    }

    void aggresiveLevel(AggresiveLevel level) {
        this.aggresiveLevel = level;
    }

    void kickdownEnabled() {
        this.kickedDown = true;
    }

    void kickdownDisabled() {
        this.kickedDown = false;
    }

    private boolean isDrifting() {
        return mDynamics && bmwExternalSystems.getAngularSpeed() > characteristics.angularSpeedForDrifting();
    }

    private GearRange gearRange() {
        return new GearRange(new Gear(1), shifter.getMaxDrive());
    }
}
