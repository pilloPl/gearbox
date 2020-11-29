package pl.januszsoft.gearboxspecific.zf8;

class Gearbox {

    private int maxDrive;
    private Object[] gearBoxCurrentParams = new Object[2]; //state, currentGear

    //state 1-Drive, 2-Park, 3-Reverse, 4-Neutral

    Object getState() {
        return gearBoxCurrentParams[0];
    }

    Object getCurrentGear() {
        return gearBoxCurrentParams[1];
    }

    void setCurrentGear(int currentGear) {
        gearBoxCurrentParams[1] = currentGear;
    }

    void setGearBoxCurrentParams(Object[] gearBoxCurrentParams) {
        if (gearBoxCurrentParams[0] != this.gearBoxCurrentParams[0]) {
            //zmienil sie state
            this.gearBoxCurrentParams[0] = gearBoxCurrentParams[0];
            Integer state = (Integer) gearBoxCurrentParams[0];
            if (state == 2) {
                setCurrentGear(0);
            }
            if (state == 3) {
                setCurrentGear(-1);
            }
            if (state == 4) {
                setCurrentGear(0);
            }
            setCurrentGear((Integer) gearBoxCurrentParams[1]);
        } else {
            setCurrentGear((Integer) gearBoxCurrentParams[1]);
        }
    }

    Integer getMaxDrive() {
        return maxDrive;
    }

    void setMaxDrive(int maxDrive) {
        this.maxDrive = maxDrive;
    }


}
