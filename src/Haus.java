public class Haus implements IInsertableObject {

    private String hausName;
    private double miete;
    private double groesse;
    private int zimmerAnzahl;
    private int adressID;

    public Haus(String hausName, double miete, double groesse, int zimmerAnzahl, int adressID) {
        this.hausName = hausName;
        this.miete = miete;
        this.groesse = groesse;
        this.zimmerAnzahl = zimmerAnzahl;
        this.adressID = adressID;
    }

    public String getHausName() {
        return hausName;
    }

    public void setHausName(String hausName) {
        this.hausName = hausName;
    }

    public double getMiete() {
        return miete;
    }

    public void setMiete(double miete) {
        this.miete = miete;
    }

    public double getGroesse() {
        return groesse;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public int getZimmerAnzahl() {
        return zimmerAnzahl;
    }

    public void setZimmerAnzahl(int zimmerAnzahl) {
        this.zimmerAnzahl = zimmerAnzahl;
    }

    public int getAdressID() {
        return adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO HAUS VALUES ('%s', %.2f, %.2f, %d, %d);", hausName, miete, groesse, zimmerAnzahl, adressID);
    }
}
