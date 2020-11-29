package pl.januszsoft.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPMTest {

    @Test
    void cannotHaveNegativeRPMs() {
        assertThrows(IllegalArgumentException.class, () -> RPM.rpm(-2));
    }

    @Test
    void kilosShouldBeEqualsToUnits() {
        assertEquals(new RPM(2000), RPM.k(2));
        assertEquals(new RPM(2500), RPM.k(2.5));
        assertEquals(new RPM(2700), RPM.k(2.7));
        assertEquals(new RPM(500), RPM.k(0.5));
    }

    @Test
    void rpmShouldBeAboveRange() {
        assertTrue(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(1000), RPM.rpm(1999))));
        assertTrue(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(1000), RPM.rpm(1000))));
        assertTrue(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(1998), RPM.rpm(1999))));

        assertFalse(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(1000), RPM.rpm(2000))));
        assertFalse(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(10), RPM.rpm(2001))));
        assertFalse(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(2000), RPM.rpm(3000))));
        assertFalse(RPM.rpm(2000).isAbove(RpmRange.of(RPM.rpm(2001), RPM.rpm(3000))));

    }

    @Test
    void rpmShouldBeBelowRange() {
        assertTrue(RPM.rpm(2000).isBelow(RpmRange.of(RPM.rpm(2001), RPM.rpm(2500))));
        assertTrue(RPM.rpm(2000).isBelow(RpmRange.of(RPM.rpm(3000), RPM.rpm(4000))));

        assertFalse(RPM.rpm(2000).isBelow(RpmRange.of(RPM.rpm(2000), RPM.rpm(2001))));
        assertFalse(RPM.rpm(2000).isBelow(RpmRange.of(RPM.rpm(1998), RPM.rpm(1999))));
        assertFalse(RPM.rpm(2000).isBelow(RpmRange.of(RPM.rpm(1998), RPM.rpm(2000))));

    }

    @Test
    void rpmShouldScale() {
        assertEquals(RPM.rpm(1000), RPM.rpm(2000).scale(0.5d));
        assertEquals(RPM.rpm(4000), RPM.rpm(2000).scale(2));
        assertEquals(RPM.rpm(5200), RPM.rpm(2000).scale(2.6d));

    }

}