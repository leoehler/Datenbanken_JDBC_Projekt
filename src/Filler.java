import java.util.ArrayList;

public class Filler extends ArrayList<IInsertableObject> {

    public Filler(){
        fillAdresse();
    }

    public void fillAdresse(){
        add(new Adresse("Gauerbach", 1, 49808, "Lingen (Ems)"));
        add(new Adresse("Kuhdamm", 45, 10220, "Berlin"));
    }

}
