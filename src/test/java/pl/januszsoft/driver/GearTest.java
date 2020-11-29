package pl.januszsoft.driver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearTest {

    @Test
    void cannotHaveGearWithNegativeRepresantation() {
        assertThrows(IllegalArgumentException.class, () -> new Gear(-2));
    }

    @Test
    void shouldCreateNextGear() {
        assertEquals(new Gear(5), new Gear(4).next());
        assertEquals(new Gear(3), new Gear(2).next());
        assertEquals(new Gear(2), new Gear(1).next());
    }

    @Test
    void shouldGreatePreviousGrear() {
        assertEquals(new Gear(5), new Gear(6).previous());
        assertEquals(new Gear(3), new Gear(4).previous());
        assertEquals(new Gear(2), new Gear(3).previous());
    }

    @Test
    void shouldCompareGreaterGear() {
        assertTrue(new Gear(5).greaterThan(new Gear(4)));
        assertTrue(new Gear(4).greaterThan(new Gear(3)));

        assertFalse(new Gear(5).greaterThan(new Gear(6)));
        assertFalse(new Gear(6).greaterThan(new Gear(6)));
    }

    @Test
    void shouldCompareLessOrEqualsGear() {
        assertTrue(new Gear(5).lessOrEqualsTo(new Gear(5)));
        assertTrue(new Gear(4).lessOrEqualsTo(new Gear(6)));

        assertFalse(new Gear(5).lessOrEqualsTo(new Gear(4)));
        assertFalse(new Gear(6).lessOrEqualsTo(new Gear(3)));
    }

}