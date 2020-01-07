import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Adresse implements IInsertableObject{
    private static int id =0;

    private final int ID;
    private String strasse;
    private int hausnummer;
    private int plz;
    private String ort;

    public Adresse(String strasse, int hausnummer, int plz, String ort) {
        ID = ++id;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    public String getSQLInsertString(){
        return "'" + strasse + "', " + hausnummer + ", " + plz + ", '" + ort + "'";
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO ADRESSE VALUES (%d, '%s', %d, %d, '%s');", ID, strasse, hausnummer, plz, ort);
    }
}
