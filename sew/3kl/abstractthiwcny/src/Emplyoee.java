public abstract class Emplyoee {
    private int empleeNumber;

    private String name;
    private String department;

    public abstract double calacslalry();

    public void workDepartment() {
        System.out.println(this.name + " works in " + this.department);
    }

    @Override
    public String toString() {
        return "Emplyoee{" +
                "empleeNumber=" + empleeNumber +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Emplyoee(int empleeNumber, String name, String department) {
        this.empleeNumber = empleeNumber;
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }
}
