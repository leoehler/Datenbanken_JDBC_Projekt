public class Spiel implements IInsertableObject {

    private String name;

    public Spiel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String insertStatement() {
        return String.format("INSERT INTO SPIEL VALUES ('%s');", name);
    }
}
