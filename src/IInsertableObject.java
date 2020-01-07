import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IInsertableObject
{
    public String insertStatement();
}
