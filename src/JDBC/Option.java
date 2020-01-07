package JDBC;

public enum Option {
    NOACTION("NO ACTION"),
    CASCADE("CASCADE"),
    RESTRICT("RESTRICT"),
    SETNULL("SET NULL"),
    SETDEFAULT("SET DEFAULT");

    private String sqlOptionString;

    Option(String sqlTypeString){
        this.sqlOptionString = sqlTypeString;
    }

    public String getSqlOptionString() {
        return sqlOptionString;
    }
}