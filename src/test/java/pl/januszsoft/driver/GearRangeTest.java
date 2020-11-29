package pl.januszsoft.driver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GearRangeTest {

    @Test
    void shouldCreateInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> new GearRange(new Gear(7), new Gear(4)));
    }


    @Test
    void shouldCreateValidRange() {
        assertDoesNotThrow(()  -> new GearRange(new Gear(3), new Gear(4)));
    }

}