package pl.januszsoft.carspecific.bmw;


class Lights {

    int position;

    /**
     * null - brak opcji w samochodzie
     * 1-3 - w dół
     * 7-10 - w górę
     * @return
     */
    public Integer getLightsPosition() {
        return position;
    }

}