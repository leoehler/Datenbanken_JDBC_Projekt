package JDBC;

import java.util.ArrayList;

public class Table {

    String name = null;
    ArrayList<Attribute> attributes = new ArrayList<>();



    public Table(String name) {
        this.name = name;
    }

    public Table addAttr(String name, Type type){
        attributes.add(new Attribute(name, type));
        return this;
    }
    public Table addPrimaryKey(String name, Type type){
        attributes.add(new PrimaryKey(name, type));
        return this;
    }

    public Table addForeignKey(String name, Type type, Table tableReferenced, Attribute attributeReferenced, boolean isPrimaryKey){
        attributes.add(new ForeignKey(name, type, tableReferenced, attributeReferenced, isPrimaryKey));
        return this;
    }

    public String create(){
        String sqlStatement = "CREATE TABLE " + name + " (";
        String sqlStatementPrimaryKeys = "";

        final int size = attributes.size();

        for (int i = 0; i < attributes.size(); i++) {
            sqlStatement += attributes.get(i).create();

            if(i < size -1){
                sqlStatement += ", ";
            }

            sqlStatementPrimaryKeys = attributes.get(i).createPrimaryKey(sqlStatementPrimaryKeys);
        }
        sqlStatement += ", PRIMARY KEY (" + sqlStatementPrimaryKeys + "));";

        return sqlStatement;
    }

    public String addConstraint(String constraintName, ForeignKey foreignKey, Option onDelete, Option onUpdate){
        String sqlStatement = "ALTER TABLE " + name +
                " ADD CONSTRAINT " + constraintName +
                " FOREIGN KEY (" + foreignKey.name + ")" +
                " REFERENCES " + foreignKey.tableReferenced.name + "( " + foreignKey.attributeReferenced.name + ")" +
                " ON DELETE " + onDelete.getSqlOptionString() + " ON UPDATE " + onUpdate.getSqlOptionString() +";";
        return sqlStatement;
    }

    public Attribute getAttribute(String name){
        for (Attribute attr: attributes) {
            if (attr.name.equals(name))
                return attr;
        }
        return null;
    }

   /* public String insert(){
        String sqlStatement = "INSERT INTO " + name +" ";
        for (Attribute attr : attributes){
            sqlStatement += attr.getSQLString();


        }



        return sqlStatement;
    }*/
}
