public class Spieler extends Person implements IInsertableObject{

    private String spiel;
    private String facebook;
    private String instagram;
    private String twitter;
    private String teamName;
    private String hausName;

    public Spieler(int SSN, String vorname, String nachname, String gebDatum, int adresse, double gehalt, int urlaubstage, String vertragsBeginn, String vertragsEnde, String spiel, String facebook, String instagram, String twitter, String teamName, String hausName) {
        super(SSN, vorname, nachname, gebDatum, adresse, gehalt, urlaubstage, vertragsBeginn, vertragsEnde);
        this.spiel = spiel;
        this.facebook = facebook;
        this.instagram = instagram;
        this.twitter = twitter;
        this.teamName = teamName;
        this.hausName = hausName;
    }

    public String getSpiel() {
        return spiel;
    }

    public void setSpiel(String spiel) {
        this.spiel = spiel;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHausName() {
        return hausName;
    }

    public void setHausName(String hausName) {
        this.hausName = hausName;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO SPIELER VALUES (%d, '%s', '%s', '%s', %d, %.2f, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", SSN, vorname, nachname, gebDatum, adresse, gehalt, urlaubstage, vertragsBeginn, vertragsEnde, spiel, facebook, instagram, twitter, teamName, hausName);
    }
}
