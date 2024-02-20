public class Studenten {
    private String name;
    private int nummer;
    private int alter;
    private String studiengang;
    public Studenten(String name,int nummer,  int alter, String studiengang){
        this.name = name;
        this.nummer = nummer;
        this.alter = alter;
        this.studiengang = studiengang;

    }

    @Override
    public String toString(){
        return "name:"+this.getName()+" nummer:"+this.getNummer() +" alter:"+this.getAlter()+" studiengang:"+this.getStudiengang();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getStudiengang() {
        return studiengang;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }
}
