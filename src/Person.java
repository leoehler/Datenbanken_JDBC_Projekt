public abstract class Person{

    protected int SSN;
    protected String vorname;
    protected String nachname;
    protected String gebDatum;
    protected int adresse;
    protected double gehalt;
    protected int urlaubstage;
    protected String vertragsBeginn;
    protected String vertragsEnde;

    public Person(int SSN, String vorname, String nachname, String gebDatum, int adresse, double gehalt, int urlaubstage, String vertragsBeginn, String vertragsEnde) {
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

    public String getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(String gebDatum) {
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

    public String getVertragsBeginn() {
        return vertragsBeginn;
    }

    public void setVertragsBeginn(String vertragsBeginn) {
        this.vertragsBeginn = vertragsBeginn;
    }

    public String getVertragsEnde() {
        return vertragsEnde;
    }

    public void setVertragsEnde(String vertragsEnde) {
        this.vertragsEnde = vertragsEnde;
    }
}