package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Statement_Singleton{
    private static Statement statement=null;
    private static Connection connection;
    private DB_Statement_Singleton (){}

    public static Statement get_DB_Statement() throws SQLException, ClassNotFoundException
    {
        if (statement!=null && !statement.isClosed())
        {
            System.out.println("new");
            return statement;
        }
        else if (statement==null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/reservations";
            connection = DriverManager.getConnection(url, "root", "");
            statement = connection.createStatement();
            return statement;
        }else       //if statement is not null but isClosed
        {
            statement = connection.createStatement();
            return statement;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        connection=null;
        super.finalize();
    }
}
