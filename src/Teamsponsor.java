public class Teamsponsor implements IInsertableObject{

    private String teamName;
    private String sponsorName;
    private double summe;
    private String beginn;
    private String ende;

    public Teamsponsor(String teamName, String sponsorName, double summe, String beginn, String ende) {
        this.teamName = teamName;
        this.sponsorName = sponsorName;
        this.summe = summe;
        this.beginn = beginn;
        this.ende = ende;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) {
        this.summe = summe;
    }

    public String getBeginn() {
        return beginn;
    }

    public void setBeginn(String beginn) {
        this.beginn = beginn;
    }

    public String getEnde() {
        return ende;
    }

    public void setEnde(String ende) {
        this.ende = ende;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO TEAMSPONSOR VALUES ('%s', '%s', %.2f, '%s', '%s');", teamName, sponsorName, summe, beginn, ende);
    }
}
