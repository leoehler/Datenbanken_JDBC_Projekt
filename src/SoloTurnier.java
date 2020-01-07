public class SoloTurnier extends Turnier implements IInsertableObject {

    public SoloTurnier(String name, String spiel, double gewinn, String datum, int platz) {
        super(name, spiel, gewinn, datum, platz);
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO SOLOTURNIER VALUES ('%s', '%s', %.2f, '%s', %d);", name, spiel, gewinn, datum, platz);
    }
}
