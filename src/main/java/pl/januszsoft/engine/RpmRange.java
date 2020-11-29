package pl.januszsoft.engine;

import java.util.Objects;

public class RpmRange {

    private final RPM start;
    private final RPM end;

    private RpmRange(RPM start, RPM end) {
        if (end.compareTo(start) < 0) {
            throw new IllegalStateException("Wrong range data, end is greater than start");
        }
        this.start = start;
        this.end = end;
    }

    public static RpmRange of(RPM from, RPM to) {
        return new RpmRange(from, to);
    }

    boolean startGreaterThan(RPM rpm) {
        return rpm.compareTo(start) < 0;
    }

    boolean endSmallerThan(RPM rpm) {
        return rpm.compareTo(end) > 0;
    }

    public RpmRange leftHalf() {
        return new RpmRange(start, end.minus(start).divideBy(2).add(start));
    }

    public RpmRange moveRight(double ratio) {
        RPM addToStart = start.scale(ratio);
        RPM addToEnd = end.scale(ratio);
        return new RpmRange(start.add(addToStart), end.add(addToEnd));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpmRange rpmRange = (RpmRange) o;
        return Objects.equals(start, rpmRange.start) &&
                Objects.equals(end, rpmRange.end);
    }

    @Override
    public String toString() {
        return "RpmRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

}
