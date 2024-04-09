package oida.oida;

public class Schüler {

    private String name;
    private int nummer;
    private int alter;
    private String abteilung;
    public Schüler(String name,int nummer,  int alter, String abeteilung){
        this.name = name;
        this.nummer = nummer;
        this.alter = alter;
        this.abteilung =abeteilung;

    }

    @Override
    public String toString(){
        return "name:"+this.getName()+"\n nummer:"+this.getNummer() +"\n alter:"+this.getAlter()+"\n studiengang:"+this.getAbteilung();
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

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

}
