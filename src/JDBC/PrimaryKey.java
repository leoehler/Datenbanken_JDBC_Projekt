package JDBC;

public class PrimaryKey extends Attribute {

    public PrimaryKey(String name, Type type) {
        super(name, type);
    }

    public String createPrimaryKey(String sqlStatementPrimaryKeys){
        return sqlStatementPrimaryKeys.isEmpty() ? name : sqlStatementPrimaryKeys + ", "+ name + "";
    }
}
