public class intern extends Emplyoee {
    private double monthlySalary;
    private String traninginsitute;
    private int duration;

    public intern(double monthySalary, String traninginsitute, int duration, String name, int empleeNumber,
            String department) {
        super(empleeNumber, name, department);
        this.monthlySalary = monthlySalary;
        this.traninginsitute = traninginsitute;
        this.duration = duration;
    }

    @Override
    public double calacslalry() {
        return this.monthlySalary;
    }

    public void attendtraining() {
        System.out.println(this.traninginsitute);
    }

}
