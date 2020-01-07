public class TeamTurnier extends Turnier implements IInsertableObject {

    protected String teamName;

    public TeamTurnier(String name, String spiel, double gewinn, String datum, int platz, String teamName) {
        super(name, spiel, gewinn, datum, platz);
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO TEAMTURNIER VALUES ('%s', '%s', %.2f, '%s', %d, '%s');", name, spiel, gewinn, datum, platz, teamName);
    }
}
