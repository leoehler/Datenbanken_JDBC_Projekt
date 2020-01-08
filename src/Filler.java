import java.util.ArrayList;

public class Filler extends ArrayList<IInsertableObject> {

    public Filler(){
        fillAll();
    }

    public void fillAll(){
        fillAdresse();
        fillCoach();
        fillHaus();
        fillIT();
        fillMarketing();
        fillSales();
        fillSpiel();
        fillSoloTurnier();
        fillTeam();
        fillSpieler();
        fillSpielerSoloturnierTeilnahme();
        fillSponsor();
        fillTeamsponsor();
        fillTestspiel();
        fillTeamTurnier();
        fillUrlaub();
    }



    public void fillAdresse(){
        add(new Adresse("Gauerbach", 1, 49808, "Lingen (Ems)"));
        add(new Adresse("Kuhdamm", 45, 10220, "Berlin"));
        add(new Adresse("Hauptstrasse", 3, 44556, "Leipzig" ));
        add(new Adresse("An der Allee", 20, 24709, "Friedrichshafen" ));
        add(new Adresse("Ringstrasse", 123, 32425, "Minden" ));
        add(new Adresse("Schlagde", 3, 32423, "Minden" ));
        add(new Adresse("Stiftsallee", 45, 32425, "Minden" ));
        add(new Adresse("Green Mile", 47, 47479, "Freiheit" ));
        add(new Adresse("Oktoberplatz", 69, 99879, "München" ));
    }

    public void fillCoach(){
        add(new Coach(123456789,"Heiland", "Java", "1990-06-25", 1, 2400,9,"2018-01-12", "2020-01-12"));
        add(new Coach(223344556,"Julian", "Schuette", "1993-12-18", 2, 1800,10,"2019-01-12", "2022-01-12"));
        add(new Coach(209445774,"Jason", "Edwards", "1990-09-28", 3, 2800,12,"2017-01-12", "2025-01-12"));
    }

    public void fillHaus(){
        add(new Haus("Tempel der Liebe", 350, 850, 4, 4 ));
        add(new Haus("Schrein der Götter", 980, 1200, 7, 5 ));
        add(new Haus("The Vat", 2550, 2500, 10, 6 ));
    }

    public void fillIT(){
        add(new IT(999999999,"Frodo", "Baggins", "1950-01-15", 8, 2000,7,"2015-01-12", "2030-01-12"));
        add(new IT(890890890,"Gandalf", "White", "1967-05-09", 8, 2000,7,"2015-01-12", "2030-01-12"));
    }

    public void fillMarketing(){
        add(new Marketing(645274910,"Luke", "Steffens", "1979-03-25", 8, 2400,9,"2017-06-12", "2022-01-12"));
        add(new Marketing(346734634,"Obi", "Kenobi", "1989-05-18", 6, 1800,10,"2017-06-12", "2022-01-12"));
        add(new Marketing(101010101,"Anakin", "Wolke", "1980-05-04", 6, 2800,12,"2017-06-12", "2023-01-12"));
    }

    public void fillSales(){
        add(new Sales(997761123,"Peter", "Zwegert", "1928-02-01", 9, 9000,50,"2010-01-01", "2100-01-01"));
    }

    public void fillSoloTurnier(){
        add(new SoloTurnier("DreamHack 17", "Tekken", 3000, "2017-09-01", 2));
        add(new SoloTurnier("DreamHack 18", "Tekken", 10000, "2018-09-01", 1));
        add(new SoloTurnier("DreamHack 19", "Tekken", 15000, "2019-09-01", 2));
    }

    public void fillSpiel(){
        add(new Spiel("Tekken"));
        add(new Spiel("Street Fighter"));
        add(new Spiel("Call of Duty"));
        add(new Spiel("Counter Strike: Global Offensive"));
        add(new Spiel("League of Legends"));
    }

    public void fillSpieler(){
        add(new Spieler(133717733, "Bruce", "Allmighty", "2000-12-24", 9, 12000, 0, "2018-12-24", "2020-12-24","Tekken", "facebook.com/brucylucy", "instagram.com/brucylucy", "twitter.com/brucylucy", "TekkenESports", "Tempel der Liebe"));
        add(new Spieler(848395732, "Walter", "White", "1989-08-24", 9, 25000, 12, "2017-06-01", "2020-06-01","League of Legends", "facebook.com/whitymighty", "instagram.com/whitymighty", "twitter.com/whitymighty", "BadBreakers", "The Vat"));
        add(new Spieler(124839304, "Jesse", "Pinkman", "1990-07-24", 8, 8000, 8, "2017-06-01", "2021-06-01","League of Legends", "facebook.com/bluelove", "instagram.com/bluelove", "twitter.com/bluelove", "BadBreakers", "The Vat"));
        add(new Spieler(991436723, "Saul", "Goodman", "1991-02-24", 8, 8500, 10, "2017-06-01", "2022-06-01","Call of Duty", "facebook.com/bettercallsaul", "instagram.com/bettercallsaul", "twitter.com/bettercallsaul", "The Ringers", "the Vat"));
    }

    public void fillSpielerSoloturnierTeilnahme(){
        add(new SpielerSoloturnierTeilnahme(133717733, "Dreamhack 17"));
        add(new SpielerSoloturnierTeilnahme(133717733, "Dreamhack 18"));
        add(new SpielerSoloturnierTeilnahme(133717733, "Dreamhack 19"));
    }

    public void fillSponsor(){
        add(new Sponsor("Red Bull", "Christian Horner", 9));
        add(new Sponsor("Grevensteiner", "Rainer Callmund", 9));
        add(new Sponsor("Monster", "Angela Schmidt", 9));
    }

    public void fillTeam(){
        add(new Team("TekkenESports", "Tekken", 123456789));
        add(new Team("BadBreakers", "League of Legends", 223344556));
        add(new Team("The Ringers", "Call of Duty", 209445774));
    }

    public void fillTeamsponsor(){
        add(new Teamsponsor("TekkenESports", "Monster", 70000, "2018-01-01","2019-01-01"));
        add(new Teamsponsor("BadBreakers", "Red Bull", 90000, "2020-01-01", "2022-01-01"));
        add(new Teamsponsor("The Ringers", "Grevensteiner", 10000, "2020-06-01", "2021-06-01"));
    }

    public void fillTeamTurnier(){
        add(new TeamTurnier("Dreamhack Summer 17", "League of Legends",10000, "2017-06-10", 4, "Bad Breakers"));
        add(new TeamTurnier("Dreamhack Summer 18", "League of Legends",30000, "2018-06-10", 2, "Bad Breakers"));
        add(new TeamTurnier("Dreamhack Summer 18", "Call of Duty", 8000, "2018-06-12", 5, "The Ringers"));
    }

    public void fillTestspiel(){
        add(new Testspiel(848395732, 124839304, "2019-12-20", "12:00", "2:4"));
        add(new Testspiel(848395732, 124839304, "2019-12-20", "14:00", "1:5"));
        add(new Testspiel(848395732, 124839304, "2019-12-20", "16:00", "1:3"));
        add(new Testspiel(848395732, 124839304, "2019-12-21", "12:00", "5:0"));
        add(new Testspiel(848395732, 124839304, "2019-12-22", "14:00", "3:0"));
    }

    public void fillUrlaub(){
        add(new Urlaub(848395732, "2019-06-01", "2019-06-20"));
        add(new Urlaub(124839304, "2019-04-20", "2019-04-24"));
        add(new Urlaub(991436723, "2019-07-20", "2019-08-01"));
    }

}
