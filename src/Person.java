import java.util.Date;

public class Person implements IInsertableObject{

    private int SSN;
    private String vorname;
    private String nachname;
    private Date gebDatum;
    private int adresse;
    private double gehalt;
    private int urlaubstage;
    private Date vertragsBeginn;
    private Date vertragsEnde;

    public Person(int SSN, String vorname, String nachname, Date gebDatum, int adresse, double gehalt, int urlaubstage, Date vertragsBeginn, Date vertragsEnde) {
        this.SSN = SSN;
        this.vorname = vorname;
        this.nachname = nachname;
        this.gebDatum = gebDatum;
        this.adresse = adresse;
        this.gehalt = gehalt;
        this.urlaubstage = urlaubstage;
        this.vertragsBeginn = vertragsBeginn;
        this.vertragsEnde = vertragsEnde;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(Date gebDatum) {
        this.gebDatum = gebDatum;
    }

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public int getUrlaubstage() {
        return urlaubstage;
    }

    public void setUrlaubstage(int urlaubstage) {
        this.urlaubstage = urlaubstage;
    }

    public Date getVertragsBeginn() {
        return vertragsBeginn;
    }

    public void setVertragsBeginn(Date vertragsBeginn) {
        this.vertragsBeginn = vertragsBeginn;
    }

    public Date getVertragsEnde() {
        return vertragsEnde;
    }

    public void setVertragsEnde(Date vertragsEnde) {
        this.vertragsEnde = vertragsEnde;
    }

    @Override
    public String insertStatement() {
        return null;
    }
}