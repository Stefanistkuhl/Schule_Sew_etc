public class Masgwehr extends Emplyoee {
    private double saladry;
    private double bonus;
    private int teamSize;

    public Masgwehr(double saladry, double bonus, int teamSize, String name, int empleeNumber, String department) {
        super(empleeNumber, name, department);
        this.saladry = saladry;
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    public void cundcutMeeting() {
        System.out.println(super.getName() + " has a meeting with their team of " + this.teamSize);
    }

    @Override
    public double calacslalry() {
        return bonus + saladry;
    }

    @Override
    public String toString() {
        return "Masgwehr{" +
                "saladry=" + saladry +
                ", bonus=" + bonus +
                ", teamSize=" + teamSize +
                '}';
    }

}
