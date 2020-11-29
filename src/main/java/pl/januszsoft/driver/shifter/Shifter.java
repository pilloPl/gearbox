package pl.januszsoft.driver.shifter;

import pl.januszsoft.driver.Gear;

public interface Shifter {

    void changeGearTo(Gear newGear);

    Gear currentGear();

    Gear getMaxDrive();
}
