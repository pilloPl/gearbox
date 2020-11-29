package pl.januszsoft.carspecific.bmw;

import pl.januszsoft.engine.RPM;
import pl.januszsoft.engine.RpmRange;

public class Characteristics {

    private Object[] characteristics = new Object[]{
            2000d,
            1000d, 1000d, 0.5d, 2500d, 4500d, 1500d, 0.5d, 5000d, 0.7d, 5000d, 5000d, 1500d, 2000d, 3000d, 6500d,
            40d
    };

    public RpmRange optimalComfortRpmRange() {
        return RpmRange.of(RPM.k((Double) characteristics[1]), RPM.k((Double) characteristics[4]));
    }

    public RpmRange optimalEcoRpmRange() {
        return RpmRange.of(RPM.k((Double) characteristics[2]), RPM.k((Double) characteristics[4]));
    }

    public double angularSpeedForDrifting() {
        return (Double) characteristics[16];
    }

    public RpmRange optimalSportRpmRange() {
        return RpmRange.of(RPM.k((Double) characteristics[14]), RPM.k((Double) characteristics[15]));
    }
}
