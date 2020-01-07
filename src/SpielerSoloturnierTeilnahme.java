public class SpielerSoloturnierTeilnahme implements IInsertableObject{

    private int spielerSSN;
    private String soloTurnierName;

    public SpielerSoloturnierTeilnahme(int spielerSSN, String soloTurnierName) {
        this.spielerSSN = spielerSSN;
        this.soloTurnierName = soloTurnierName;
    }

    public int getSpielerSSN() {
        return spielerSSN;
    }

    public void setSpielerSSN(int spielerSSN) {
        this.spielerSSN = spielerSSN;
    }

    public String getSoloTurnierName() {
        return soloTurnierName;
    }

    public void setSoloTurnierName(String soloTurnierName) {
        this.soloTurnierName = soloTurnierName;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO SPIELER_SOLOTURNIER_TEILNAHME VALUES (%d, '%s');", spielerSSN, soloTurnierName);
    }
}
