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

        /*
        ForeignKey fk_1 = new ForeignKey("ADRESSE", Type.INTEGER, table_adresse , table_adresse.getAttribute("ID"), false);
        sqlStatement = table_person.addConstraint("ADRESSE__ADRESSE_ID",fk_1, Option.SETNULL, Option.CASCADE);
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);
        */
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
