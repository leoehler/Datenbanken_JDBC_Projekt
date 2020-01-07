public abstract class Turnier {

    protected String name;
    protected String spiel;
    protected double gewinn;
    protected String datum;
    protected int platz;

    public Turnier(String name, String spiel, double gewinn, String datum, int platz) {
        this.name = name;
        this.spiel = spiel;
        this.gewinn = gewinn;
        this.datum = datum;
        this.platz = platz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpiel() {
        return spiel;
    }

    public void setSpiel(String spiel) {
        this.spiel = spiel;
    }

    public double getGewinn() {
        return gewinn;
    }

    public void setGewinn(double gewinn) {
        this.gewinn = gewinn;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getPlatz() {
        return platz;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }
}
