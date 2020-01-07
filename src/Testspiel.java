public class Testspiel implements IInsertableObject {

    private int spieler1ssn;
    private int spieler2ssn;
    private String datum;
    private String uhrzeit;
    private String ergebnis;

    public Testspiel(int spieler1ssn, int spieler2ssn, String datum, String uhrzeit, String ergebnis) {
        this.spieler1ssn = spieler1ssn;
        this.spieler2ssn = spieler2ssn;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.ergebnis = ergebnis;
    }

    public int getSpieler1ssn() {
        return spieler1ssn;
    }

    public void setSpieler1ssn(int spieler1ssn) {
        this.spieler1ssn = spieler1ssn;
    }

    public int getSpieler2ssn() {
        return spieler2ssn;
    }

    public void setSpieler2ssn(int spieler2ssn) {
        this.spieler2ssn = spieler2ssn;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO TESTSPIEL VALUES (%d, %d, '%s', '%s', '%s');", spieler1ssn, spieler2ssn, datum, uhrzeit, ergebnis);
    }
}
