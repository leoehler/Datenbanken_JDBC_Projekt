public class IT extends Person implements IInsertableObject {

    public IT(int SSN, String vorname, String nachname, String gebDatum, int adresse, double gehalt, int urlaubstage, String vertragsBeginn, String vertragsEnde) {
        super(SSN, vorname, nachname, gebDatum, adresse, gehalt, urlaubstage, vertragsBeginn, vertragsEnde);
    }


    @Override
    public String insertStatement() {
        return String.format("INSERT INTO IT VALUES (%d, '%s', '%s', '%s', %d, %.2f, %d, '%s', '%s');", SSN, vorname, nachname, gebDatum, adresse, gehalt, urlaubstage, vertragsBeginn, vertragsEnde);
    }
}
