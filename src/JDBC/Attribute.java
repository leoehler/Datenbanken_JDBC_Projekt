package JDBC;

public class Attribute {

    String name;
    Type type;

    public Attribute(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String create(){
        return name + " " +  type.getSqlTypeString();
    }

    public String createPrimaryKey(String sqlStatementPrimaryKeys){
        return sqlStatementPrimaryKeys;
    }
}
