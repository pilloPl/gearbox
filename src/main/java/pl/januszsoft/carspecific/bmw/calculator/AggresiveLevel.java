package pl.januszsoft.carspecific.bmw.calculator;

import pl.januszsoft.engine.RpmRange;

enum AggresiveLevel {

    First(0), Second(0.1), Third(0.3d);

    private double ratio;

    AggresiveLevel(double ratio) {
        this.ratio = ratio;
    }

    RpmRange modify(RpmRange range) {
        return range.moveRight(ratio);
    }
}