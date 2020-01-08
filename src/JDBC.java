import JDBC.*;
import JDBC.Table;
import JDBC.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class JDBC {

      public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/", "root", "password");
        System.out.println("Connection established");
        return connection;
    }

    public static int updateStatement(Connection connection, String sqlStatement) throws SQLException{
        Statement statement = connection.createStatement();
        int tuplesUpdated = statement.executeUpdate(sqlStatement);

        System.out.println("SQL Update executed : " + sqlStatement);
        return tuplesUpdated;
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            Connection connection = getConnection();
            createSchema(connection, "eSportsTeam");
            createTables(connection);

            ArrayList<IInsertableObject> objectsToInsert = new Filler();
            for (IInsertableObject io: objectsToInsert) {
                insertInto(connection, io);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Fehlermeldung: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException, NullPointerException {
          //ADRESSE
          Table table_adresse = new Table("ADRESSE")
                .addPrimaryKey("ID", Type.INTEGER)
                .addAttr("STRASSE", Type.VARCHAR)
                .addAttr("HAUSNUMMER", Type.INTEGER)
                .addAttr("PLZ", Type.INTEGER)
                .addAttr("ORT", Type.VARCHAR);
          String sqlStatement = table_adresse.create();
          System.out.println(sqlStatement);
          updateStatement(connection, sqlStatement);
                //SPIELER
          Table table_spieler = new Table("SPIELER")
              .addPrimaryKey("SSN", Type.INTEGER)
              .addAttr("VNAME", Type.VARCHAR)
              .addAttr("NNAME", Type.VARCHAR)
              .addAttr("GDATUM", Type.DATE)
              .addAttr("ADRESSE", Type.INTEGER)
              .addAttr("GEHALT", Type.DECIMAL)
              .addAttr("URLAUBSTAGE", Type.VARCHAR)
              .addAttr("VERTRAGSBEGINN", Type.DATE)
              .addAttr("VERTRAGSENDE", Type.DATE)
              .addAttr("SPIEL", Type.VARCHAR)
              .addAttr("FACEBOOK", Type.VARCHAR)
              .addAttr("INSTAGRAM", Type.VARCHAR)
              .addAttr("TWITTER", Type.VARCHAR)
              .addAttr("TEAMNAME", Type.VARCHAR)
              .addAttr("HAUSNAME", Type.VARCHAR);
          sqlStatement = table_spieler.create();
          System.out.println(sqlStatement);
          updateStatement(connection, sqlStatement);

          //IT
        Table table_IT = new Table("IT")
                .addPrimaryKey("SSN", Type.INTEGER)
                .addAttr("VNAME", Type.VARCHAR)
                .addAttr("NNAME", Type.VARCHAR)
                .addAttr("GDATUM", Type.DATE)
                .addAttr("ADRESSE", Type.INTEGER)
                .addAttr("GEHALT", Type.DECIMAL)
                .addAttr("URLAUBSTAGE", Type.VARCHAR)
                .addAttr("VERTRAGSBEGINN", Type.DATE)
                .addAttr("VERTRAGSENDE", Type.DATE);
        sqlStatement = table_IT.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SALES
        Table table_sales = new Table("SALES")
                .addPrimaryKey("SSN", Type.INTEGER)
                .addAttr("VNAME", Type.VARCHAR)
                .addAttr("NNAME", Type.VARCHAR)
                .addAttr("GDATUM", Type.DATE)
                .addAttr("ADRESSE", Type.INTEGER)
                .addAttr("GEHALT", Type.DECIMAL)
                .addAttr("URLAUBSTAGE", Type.VARCHAR)
                .addAttr("VERTRAGSBEGINN", Type.DATE)
                .addAttr("VERTRAGSENDE", Type.DATE);
        sqlStatement = table_sales.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //MARKETING
        Table table_marketing = new Table("MARKETING")
                .addPrimaryKey("SSN", Type.INTEGER)
                .addAttr("VNAME", Type.VARCHAR)
                .addAttr("NNAME", Type.VARCHAR)
                .addAttr("GDATUM", Type.DATE)
                .addAttr("ADRESSE", Type.INTEGER)
                .addAttr("GEHALT", Type.DECIMAL)
                .addAttr("URLAUBSTAGE", Type.VARCHAR)
                .addAttr("VERTRAGSBEGINN", Type.DATE)
                .addAttr("VERTRAGSENDE", Type.DATE);
        sqlStatement = table_marketing.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //COACH
        Table table_coach = new Table("COACH")
                .addPrimaryKey("SSN", Type.INTEGER)
                .addAttr("VNAME", Type.VARCHAR)
                .addAttr("NNAME", Type.VARCHAR)
                .addAttr("GDATUM", Type.DATE)
                .addAttr("ADRESSE", Type.INTEGER)
                .addAttr("GEHALT", Type.DECIMAL)
                .addAttr("URLAUBSTAGE", Type.VARCHAR)
                .addAttr("VERTRAGSBEGINN", Type.DATE)
                .addAttr("VERTRAGSENDE", Type.DATE);
        sqlStatement = table_coach.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //TESTSPIEL
        Table table_testspiel = new Table("TESTSPIEL")
                .addPrimaryKey("SPIELERSSN_1", Type.INTEGER)
                .addPrimaryKey("SPIELERSSN_2", Type.INTEGER)
                .addPrimaryKey("DATUM", Type.DATE)
                .addPrimaryKey("UHRZEIT", Type.VARCHAR)
                .addAttr("ERGEBNIS", Type.VARCHAR);
        sqlStatement = table_testspiel.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //TEAM
        Table table_team = new Table("TEAM")
                .addPrimaryKey("TEAMNAME", Type.VARCHAR)
                .addAttr("SPIEL", Type.VARCHAR)
                .addAttr("COACHSSN", Type.INTEGER);
        sqlStatement = table_team.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SPONSOR
        Table table_sponsor = new Table("SPONSOR")
                .addPrimaryKey("NAME", Type.VARCHAR)
                .addAttr("ANSPRECHPARTNER", Type.VARCHAR)
                .addAttr("ADRESSE", Type.INTEGER);
        sqlStatement = table_sponsor.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //TEAMSPONSOR
        Table table_teamsponsor = new Table("TEAMSPONSOR")
                .addPrimaryKey("TEAMNAME", Type.VARCHAR)
                .addPrimaryKey("SPONSORNAME", Type.VARCHAR)
                .addAttr("SUMME", Type.DECIMAL)
                .addPrimaryKey("BEGINN", Type.DATE)
                .addAttr("ENDE", Type.DATE);
        sqlStatement = table_teamsponsor.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //TEAMTURNIER
        Table table_teamturnier = new Table("TEAMTURNIER")
                .addPrimaryKey("NAME", Type.VARCHAR)
                .addPrimaryKey("SPIEL", Type.VARCHAR)
                .addAttr("GEWINN", Type.DECIMAL)
                .addAttr("DATUM", Type.DATE)
                .addAttr("PLATZ", Type.INTEGER)
                .addAttr("TEAMNAME", Type.VARCHAR);
        sqlStatement = table_teamturnier.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //SOLOTURNIER
        Table table_soloturnier = new Table("SOLOTURNIER")
                .addPrimaryKey("NAME", Type.VARCHAR)
                .addPrimaryKey("SPIEL", Type.VARCHAR)
                .addAttr("GEWINN", Type.DECIMAL)
                .addAttr("DATUM", Type.DATE)
                .addAttr("PLATZ", Type.INTEGER);
        sqlStatement = table_soloturnier.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SPIELERSOLOTURNIERTEILNAHME
        Table table_spielerSoloTurnierTeilnahme = new Table("SPIELER_SOLOTURNIER_TEILNAHME")
                .addPrimaryKey("SPIELERSSN", Type.INTEGER)
                .addPrimaryKey("SOLOTURNIERNAME", Type.VARCHAR);
        sqlStatement = table_spielerSoloTurnierTeilnahme.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //SPIEL
        Table table_spiel = new Table("SPIEL")
                .addPrimaryKey("NAME", Type.VARCHAR);
        sqlStatement = table_spiel.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //URLAUB
        Table table_urlaub = new Table("URLAUB")
                .addPrimaryKey("PERSONSSN", Type.INTEGER)
                .addPrimaryKey("BEGINN", Type.DATE)
                .addPrimaryKey("ENDE", Type.DATE);
        sqlStatement = table_urlaub.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //HAUS
        Table table_haus = new Table("HAUS")
                .addPrimaryKey("HAUSNAME", Type.VARCHAR)
                .addAttr("MIETE", Type.DECIMAL)
                .addAttr("GROESSE", Type.DECIMAL)
                .addAttr("ZIMMERANZAHL", Type.INTEGER)
                .addAttr("ADRESSID", Type.INTEGER);
        sqlStatement = table_haus.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);


        //Constraints

        //COACH
        ForeignKey fk_coach = new ForeignKey("ADRESSE", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_coach.addConstraint("COACH_ADRESSE__ADRESSE_ID", fk_coach, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //HAUS
        ForeignKey fk_haus = new ForeignKey("ADRESSID", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_haus.addConstraint("HAUS_ADRESSID__ADRESSE_ID", fk_haus, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //IT
        ForeignKey fk_IT = new ForeignKey("ADRESSE", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_IT.addConstraint("IT_ADRESSE__ADRESSE_ID", fk_IT, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //MARKETING
        ForeignKey fk_marketing = new ForeignKey("ADRESSE", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_marketing.addConstraint("MARKETING_ADRESSE__ADRESSE_ID", fk_marketing, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SALES
        ForeignKey fk_sales = new ForeignKey("ADRESSE", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_sales.addConstraint("SALES_ADRESSE__ADRESSE_ID", fk_sales, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SOLOTURNIER
        ForeignKey fk_soloturnier = new ForeignKey("SPIEL", Type.VARCHAR, table_spiel , table_spiel.getAttribute("NAME"), false);
        sqlStatement = table_soloturnier.addConstraint("SOLOTURNIER_SPIEL__SPIEL_NAME", fk_soloturnier, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SPIELER
        ForeignKey fk_spieler_1 = new ForeignKey("ADRESSE", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_spieler.addConstraint("SPIELER_ADRESSE__ADRESSE_ID", fk_spieler_1, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_spieler_2 = new ForeignKey("TEAMNAME", Type.VARCHAR, table_team , table_team.getAttribute("TEAMNAME"), false);
        sqlStatement = table_spieler.addConstraint("SPIELER_TEAMNAME__TEAM_TEAMNAME", fk_spieler_2, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_spieler_3 = new ForeignKey("HAUSNAME", Type.VARCHAR, table_haus , table_haus.getAttribute("HAUSNAME"), false);
        sqlStatement = table_spieler.addConstraint("SPIELER_HAUSNAME__HAUS_HAUSNAME", fk_spieler_3, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SPIELER_SOLOTURNIER_TEILNAHME
        ForeignKey fk_SSTT = new ForeignKey("SPIELERSSN", Type.INTEGER, table_spieler , table_spieler.getAttribute("SSN"), false);
        sqlStatement = table_spielerSoloTurnierTeilnahme.addConstraint("SSTT_SPIELERSSN__SPIELER_SSN", fk_SSTT, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_SSTT_2 = new ForeignKey("SOLOTURNIERNAME", Type.VARCHAR, table_soloturnier , table_soloturnier.getAttribute("NAME"), false);
        sqlStatement = table_spielerSoloTurnierTeilnahme.addConstraint("SSTT_SOLOTURNIERNAME__SOLOTURNIER_NAME", fk_SSTT_2, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //SPONSOR
        ForeignKey fk_sponsor = new ForeignKey("ADRESSE", Type.VARCHAR, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_sponsor.addConstraint("SPONSOR_ADRESSE__ADRESSE_ID", fk_sponsor, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //TEAM
        ForeignKey fk_team = new ForeignKey("COACHSSN", Type.INTEGER, table_coach , table_coach.getAttribute("SSN"), false);
        sqlStatement = table_team.addConstraint("TEAM_COACHSSN__COACH_SSN", fk_team, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_team_2 = new ForeignKey("SPIEL", Type.VARCHAR, table_spiel , table_spiel.getAttribute("NAME"), false);
        sqlStatement = table_team.addConstraint("TEAM_SPIEL__SPIEL_NAME", fk_team_2, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //TEAMSPONSOR
        ForeignKey fk_teamsponsor = new ForeignKey("TEAMNAME", Type.VARCHAR, table_team , table_team.getAttribute("TEAMNAME"), false);
        sqlStatement = table_teamsponsor.addConstraint("TEAMSPONSOR_TEAMNAME__TEAM_TEAMNAME", fk_teamsponsor, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_teamsponsor_2 = new ForeignKey("SPONSORNAME", Type.VARCHAR, table_sponsor , table_sponsor.getAttribute("NAME"), false);
        sqlStatement = table_teamsponsor.addConstraint("TEAMSPONSOR_SPONSORNAME__SPONSOR_NAME", fk_teamsponsor_2, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //TEAMTURNIER
        ForeignKey fk_teamturnier = new ForeignKey("SPIEL", Type.VARCHAR, table_spiel , table_spiel.getAttribute("NAME"), false);
        sqlStatement = table_teamturnier.addConstraint("TEAMTURNIER_SPIEL__SPIEL_NAME", fk_teamturnier, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_teamturnier_2 = new ForeignKey("TEAMNAME", Type.VARCHAR, table_team , table_team.getAttribute("TEAMNAME"), false);
        sqlStatement = table_teamturnier.addConstraint("TEAMTURNIER_TEAMNAME__TEAM_TEAMNAME", fk_teamturnier_2, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //TESTSPIEL
        ForeignKey fk_testspiel = new ForeignKey("SPIELERSSN_1", Type.INTEGER, table_spieler , table_spieler.getAttribute("SSN"), false);
        sqlStatement = table_testspiel.addConstraint("TESTSPIEL_SPIELERSSN_1__SPIELER_SSN", fk_testspiel, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        ForeignKey fk_testspiel_2 = new ForeignKey("SPIELERSSN_2", Type.INTEGER, table_spieler , table_spieler.getAttribute("SSN"), false);
        sqlStatement = table_testspiel.addConstraint("SSTT_SPIELERSSN_2__SPIELER_SSN", fk_testspiel_2, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

        //URLAUB
        ForeignKey fk_urlaub = new ForeignKey("PERSONSSN", Type.INTEGER, table_spieler , table_spieler.getAttribute("SSN"), false);
        sqlStatement = table_urlaub.addConstraint("URLAUB_PERSONSSN__SPIELER_SSN", fk_urlaub, Option.RESTRICT, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);

    }

    private static void createSchema(Connection connection, String schemaName) throws SQLException {
        Schema schema = new Schema(schemaName);
        updateStatement(connection, schema.drop());
        updateStatement(connection, schema.create());
        updateStatement(connection, schema.use());
    }

    public static void insertInto(Connection connection, IInsertableObject io) throws SQLException {
        updateStatement(connection, io.insertStatement());
    }

}
