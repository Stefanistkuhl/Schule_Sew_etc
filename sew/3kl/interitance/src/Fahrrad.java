public class Fahrrad extends Fahrzeug {
    public boolean isHatklingel() {
        return hatklingel;
    }

    public void setHatklingel(boolean hatklingel) {
        this.hatklingel = hatklingel;
    }

    private boolean hatklingel;

    public Fahrrad(boolean hatklingel) {
        this.hatklingel = hatklingel;
    }

    public void fahren() {
        if (this.hatklingel) {
            System.out.println("Das Auto fährt " + getGeschwindigkeit() + " km/h und hat eine Klingel");
        } else {
            System.out.println("Das Auto fährt " + getGeschwindigkeit() + " km/h und hat keine Klingel");
        }
    }
}
