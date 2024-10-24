import java.util.ArrayList;

public class pprogrammer extends Emplyoee {

    private double hourlydwage;
    private int workedhours;
    private ArrayList<String> programminglangs = new ArrayList<>();
    private String project;

    public pprogrammer(double hourlydwage, int workedhours, ArrayList<String> programminglangs, String project,
            String name, int empleeNumber, String department) {
        super(empleeNumber, name, department);
        this.hourlydwage = hourlydwage;
        this.workedhours = workedhours;
        this.programminglangs = programminglangs;
        this.project = project;

    }

    @Override
    public double calacslalry() {
        return this.hourlydwage * this.workedhours;
    }

    public void showprogramminglangs() {
        System.out.println(this.programminglangs.toString());
    }

    public void writecode() {
        System.out.println(this.project);
    }

}
