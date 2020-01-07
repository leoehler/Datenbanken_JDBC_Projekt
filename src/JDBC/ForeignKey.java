package JDBC;

public class ForeignKey extends Attribute {
    Table tableReferenced;
    Attribute attributeReferenced;
    boolean isPrimaryKey;

    public ForeignKey(String name, Type type,
                      Table tableReferenced, Attribute attributeReferenced,
                      boolean isPrimaryKey) {
        super(name, type);
        this.tableReferenced = tableReferenced;
        this.attributeReferenced = attributeReferenced;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String create(){
        return super.create()
                + ", FOREIGN KEY (" + name + ") REFERENCES "
                + tableReferenced.name
                + "(" + attributeReferenced.name + ")";
    }

    public String createPrimaryKey(String sqlStatementPrimaryKeys){
        if(isPrimaryKey)
            return sqlStatementPrimaryKeys.isEmpty()
                ? name : sqlStatementPrimaryKeys + ", name";
        else
            return sqlStatementPrimaryKeys;

    }
}
