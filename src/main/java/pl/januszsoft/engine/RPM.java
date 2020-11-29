package pl.januszsoft.engine;

import java.util.Objects;

public class RPM implements Comparable<RPM> {

    private final Long rpm;

    public static RPM k(double k) {
        return RPM.rpm((long) (k * 1000));
    }

    static RPM rpm(long rpm) {
        return new RPM(rpm);
    }

    RPM(long rpm) {
        if (rpm < 0) {
            throw new IllegalArgumentException("Negative RPM: " + rpm);
        }
        this.rpm = rpm;
    }

    @Override
    public int compareTo(RPM other) {
        return rpm.compareTo(other.rpm);
    }

    public boolean isBelow(RpmRange optimalRange) {
        return optimalRange.startGreaterThan(this);
    }

    public boolean isAbove(RpmRange optimalRange) {
        return optimalRange.endSmallerThan(this);
    }

    RPM minus(RPM substract) {
        return new RPM(rpm - substract.rpm);
    }

    RPM divideBy(double dividor) {
        return new RPM((long) (rpm / dividor));
    }

    RPM add(RPM toAdd) {
        return new RPM(rpm + toAdd.rpm);
    }

    @Override
    public String toString() {
        return "RPM{" +
                "rpm=" + rpm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPM rpm1 = (RPM) o;
        return Objects.equals(rpm, rpm1.rpm);
    }

    RPM scale(double shiftPercentage) {
        return new RPM((long) (rpm * shiftPercentage));
    }
}
