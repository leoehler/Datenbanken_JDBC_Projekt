public class Urlaub implements IInsertableObject{

    private int personSSN;
    private String beginn;
    private String ende;

    public Urlaub(int personSSN, String beginn, String ende) {
        this.personSSN = personSSN;
        this.beginn = beginn;
        this.ende = ende;
    }

    public int getPersonSSN() {
        return personSSN;
    }

    public void setPersonSSN(int personSSN) {
        this.personSSN = personSSN;
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
        return String.format("INSERT INTO URLAUB VALUES (%d, '%s', '%s');", personSSN, beginn, ende);
    }
}
