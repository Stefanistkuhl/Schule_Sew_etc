public class Fahrrad extends Fahrzeug {
    protected boolean isHatklingel() {
        return hatklingel;
    }

    public void setHatklingel(boolean hatklingel) {
        this.hatklingel = hatklingel;
    }

    private boolean hatklingel;

    public Fahrrad(double geschwindigkeit, boolean hatklingel) {
        super(geschwindigkeit);
        this.hatklingel = hatklingel;
    }

    @Override
    public void fahren() {
        if (this.hatklingel) {
            System.out.println("Das Auto fährt " + super.geschwindigkeit + " km/h und hat eine Klingel");
        } else {
            System.out.println("Das Auto fährt " + super.geschwindigkeit + " km/h und hat keine Klingel");
        }
    }
}
