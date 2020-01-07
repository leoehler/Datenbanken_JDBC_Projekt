import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Filler extends ArrayList<IInsertableObject> {

    public Filler(){
        fillAdresse();
        fillCoach();
    }

    public void fillAdresse(){
        add(new Adresse("Gauerbach", 1, 49808, "Lingen (Ems)"));
        add(new Adresse("Kuhdamm", 45, 10220, "Berlin"));
    }

    public void fillCoach(){
        add(new Coach(123456789,"Peter", "Lustig", "1993-09-25", 2, 450,5,"2019-01-12", "2020-01-12"));
    }

}
