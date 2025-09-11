package org.example;

public class Thing {
    public Thing(String frage, String antwort, boolean gelernt, int anzahlGefragt, int anzahlRichtig) {
        this.frage = frage;
        this.antwort = antwort;
        this.gelernt = gelernt;
        this.anzahlGefragt = anzahlGefragt;
        this.anzahlRichtig = anzahlRichtig;
    }

    private String frage;

    @Override
    public String toString() {
        return "Thing{" +
                "frage='" + frage + '\'' +
                ", antwort='" + antwort + '\'' +
                ", gelernt=" + gelernt +
                ", anzahlGefragt=" + anzahlGefragt +
                ", anzahlRichtig=" + anzahlRichtig +
                '}';
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public boolean isGelernt() {
        return gelernt;
    }

    public void setGelernt(boolean gelernt) {
        this.gelernt = gelernt;
    }

    public int getAnzahlGefragt() {
        return anzahlGefragt;
    }

    public void setAnzahlGefragt(int anzahlGefragt) {
        this.anzahlGefragt = anzahlGefragt;
    }

    public int getAnzahlRichtig() {
        return anzahlRichtig;
    }

    public void setAnzahlRichtig(int anzahlRichtig) {
        this.anzahlRichtig = anzahlRichtig;
    }

    private String antwort;
    private boolean gelernt;
    private int anzahlGefragt;
    private int anzahlRichtig;
}
