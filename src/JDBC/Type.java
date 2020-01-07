package JDBC;

public enum Type {
    BOOLEAN("BOOLEAN"),
    INTEGER("INTEGER"),
    DECIMAL("DECIMAL(10,2)"),
    VARCHAR("VARCHAR(255)"),
    DATE("DATE");

    private String sqlTypeString;

    Type(String sqlTypeString){
        this.sqlTypeString = sqlTypeString;
    }

    public String getSqlTypeString() {
        return sqlTypeString;
    }
}
