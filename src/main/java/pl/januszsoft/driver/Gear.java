package pl.januszsoft.driver;

public class Gear {

    private final int numRepresentation; //TODO byte

    public Gear(int numRepresentation) {
        if (numRepresentation <= 0) {
            throw new IllegalArgumentException("Invalid numeric representation: " + numRepresentation);
        }
        this.numRepresentation = numRepresentation;
    }

    boolean greaterThan(Gear other) {
        return numRepresentation > other.numRepresentation;
    }

    boolean lessOrEqualsTo(Gear gear) {
        return this.numRepresentation <= gear.numRepresentation;
    }

    public Gear next() {
        return new Gear(numRepresentation + 1);
    }

    public Gear previous() {
        return new Gear(numRepresentation - 1);
    }

    public int intValue() {
        return numRepresentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear that = (Gear) o;
        return numRepresentation == that.numRepresentation;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "numRepresentation=" + numRepresentation +
                '}';
    }

}