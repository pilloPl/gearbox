package pl.januszsoft.driver;

public class GearRange {

    private final Gear maxGear;
    private final Gear first;

    public GearRange(Gear first, Gear maxGear) {
        if (first.greaterThan(maxGear)) {
            throw new IllegalArgumentException("Invalid Range. " + first + " is greater than " + maxGear);
        }
        this.maxGear = maxGear;
        this.first = first;
    }

    public Gear trim(Gear gear) {
        if (gear.greaterThan(maxGear)) {
            return maxGear;
        }
        if (gear.lessOrEqualsTo(first)) {
            return first;
        }
        return gear;
    }


}
