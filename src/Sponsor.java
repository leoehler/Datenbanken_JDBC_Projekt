public class Sponsor implements IInsertableObject {

    private String name;
    private String ansprechpartner;
    private int adresse;

    public Sponsor(String name, String ansprechpartner, int adresse) {
        this.name = name;
        this.ansprechpartner = ansprechpartner;
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public int getAdresse() {
        return adresse;
    }

    public void setAdresse(int adresse) {
        this.adresse = adresse;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO SPONSOR VALUES ('%s', '%s', %d);", name, ansprechpartner, adresse);
    }
}
