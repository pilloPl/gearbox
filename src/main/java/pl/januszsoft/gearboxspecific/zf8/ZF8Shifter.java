package pl.januszsoft.gearboxspecific.zf8;

import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.shifter.Shifter;


public class ZF8Shifter implements Shifter {

    private final Gearbox zf8gearbox;

    ZF8Shifter(Gearbox zf8gearbox) {
        this.zf8gearbox = zf8gearbox;
    }

    @Override
    public void changeGearTo(Gear newGear) {
        zf8gearbox.setCurrentGear(newGear.intValue());
    }

    @Override
    public Gear currentGear() {
        return new Gear((Integer) zf8gearbox.getCurrentGear());
    }

    @Override
    public Gear getMaxDrive() {
        return new Gear(zf8gearbox.getMaxDrive());
    }

}

