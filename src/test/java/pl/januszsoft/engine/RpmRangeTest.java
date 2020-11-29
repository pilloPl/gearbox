package pl.januszsoft.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RpmRangeTest {

    @Test
    void shouldCreateInvalidRange() {
        assertThrows(IllegalStateException.class, () -> RpmRange.of(RPM.k(5), RPM.k(3)));
    }



    @Test
    void shouldCreateValidRange() {
        assertDoesNotThrow(() -> RpmRange.of(RPM.k(3), RPM.k(5)));
    }

    @Test
    void shouldMoveToTheRight() {
        //given
        RpmRange range = RpmRange.of(RPM.k(3), RPM.k(4));

        //expect
        assertEquals(RpmRange.of(RPM.k(4.5), RPM.k(6)), range.moveRight(0.5));
        assertEquals(RpmRange.of(RPM.k(6), RPM.k(8)), range.moveRight(1));
        assertEquals(RpmRange.of(RPM.k(3), RPM.k(4)), range.moveRight(0));
    }

    @Test
    void shouldCalculateLEftHalf() {
        //given
        RpmRange range = RpmRange.of(RPM.k(3), RPM.k(4));

        //expect
        assertEquals(RpmRange.of(RPM.k(3), RPM.k(3.5)), range.leftHalf());

    }




}