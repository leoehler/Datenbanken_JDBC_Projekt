public class Team implements IInsertableObject {

    private String name;
    private String spiel;
    private int coachSSN;

    public Team(String name, String spiel, int coachSSN) {
        this.name = name;
        this.spiel = spiel;
        this.coachSSN = coachSSN;
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

    public int getCoachSSN() {
        return coachSSN;
    }

    public void setCoachSSN(int coachSSN) {
        this.coachSSN = coachSSN;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO TEAM VALUES ('%s', '%s', %d);", name, spiel, coachSSN);
    }
}