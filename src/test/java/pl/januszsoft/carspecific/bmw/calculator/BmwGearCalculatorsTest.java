package pl.januszsoft.carspecific.bmw.calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.januszsoft.carspecific.bmw.BmwExternalSystems;
import pl.januszsoft.carspecific.bmw.Characteristics;
import pl.januszsoft.carspecific.boringcommoncar.MaintainGear;
import pl.januszsoft.driver.Gear;
import pl.januszsoft.driver.calculator.GearCalculator;
import pl.januszsoft.gearboxspecific.zf8.ZF8Shifter;

import static org.assertj.core.api.Assertions.assertThat;

class BmwGearCalculatorsTest {

    BmwGearCalculators bmwGearCalculators; //SUT
    ZF8Shifter zf8Shifter;

    @BeforeEach
    public void setup() {
        zf8Shifter = zf8ShifterWith8Gears();
        bmwGearCalculators = new BmwGearCalculators(bmwCharacteristics(), zf8Shifter, bmwExternalSystems());
    }

    @Test
    void should_maintain_gear_when_drifting_with_m_dynamics() {
        //given
        bmwGearCalculators.enableMDynamics();

        //when
        GearCalculator suggestedCalculator = bmwGearCalculators.suggest();

        //then
        assertThat(suggestedCalculator).isInstanceOf(MaintainGear.class);
    }

    @Test
    void should_suggest_double_kickdown_when_kickDown_in_sport_mode() {
        //given
        bmwGearCalculators.kickdownEnabled();
        //and
        bmwGearCalculators.sportMode();

        //when
        GearCalculator suggestedCalculator = bmwGearCalculators.suggest();

        //then
        assertThat(suggestedCalculator).isInstanceOf(DoubleKickdown.class);
    }


    ZF8Shifter zf8ShifterWith8Gears() {
        ZF8Shifter stub = Mockito.mock(ZF8Shifter.class);
        Mockito.when(stub.getMaxDrive()).thenReturn(new Gear(8));
        return stub;
    }

    BmwExternalSystems bmwExternalSystems() {
        return new BmwExternalSystems();
    }

    Characteristics bmwCharacteristics() {
        return new Characteristics();
    }
}