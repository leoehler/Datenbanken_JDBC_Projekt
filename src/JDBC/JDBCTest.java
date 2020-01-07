package JDBC;

import java.sql.*;

public class JDBCTest {

    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "password");
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
            Connection connection = getConnection();
            createSchema(connection, "COFFEE_COMPANY");
            createTables(connection);


            connection.close();
        } catch (SQLException e) {
            System.out.println("Fehlermeldung: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        Table table_suppliers = new Table("SUPPLIERS")
            .addPrimaryKey("SUP_ID", Type.INTEGER)
            .addAttr("SUP_NAME", Type.VARCHAR)
            .addAttr("STREET", Type.VARCHAR)
            .addAttr("CITY", Type.VARCHAR)
            .addAttr("STATE", Type.VARCHAR)
            .addAttr("ZIP", Type.VARCHAR);

        String sqlStatement = table_suppliers.create();
        System.out.println(sqlStatement);
        updateStatement(connection, sqlStatement);
    }

    private static void createSchema(Connection connection, String schemaName) throws SQLException {
        Schema schema = new Schema(schemaName);
        updateStatement(connection, schema.drop());
        updateStatement(connection, schema.create());
        updateStatement(connection, schema.use());
    }

}
