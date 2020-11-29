package pl.januszsoft.carspecific.bmw.testdoubles;

import org.mockito.Mockito;
import pl.januszsoft.carspecific.bmw.BmwExternalSystems;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.gearboxspecific.zf8.ZF8Shifter;

public class BmwTestDoubles {

    public static ZF8Shifter zf8ShifterWith8Gears() {
        ZF8Shifter stub = Mockito.mock(ZF8Shifter.class);
        Mockito.when(stub.getMaxDrive()).thenReturn(new Gear(8));
        return stub;
    }

    public static BmwExternalSystems bmwExternalSystems() {
        BmwExternalSystems stub = Mockito.mock(BmwExternalSystems.class);
        return stub;
    }



}
