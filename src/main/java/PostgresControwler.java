import lombok.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mohammed on 6/11/2016.
 */

@Data
public class PostgresControwler {

    private static String username;
    private static String password;
    private static String url;
    DbConnectorInsertAndSelectData dbConnectorInsertAndSelectData = new DbConnectorInsertAndSelectData();

    public Connection connection;


    public PostgresControwler(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url =  url;
    }


    public void connectionToPostGres() throws  ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Trying to connect with postgresql");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exit() throws  ClassNotFoundException, SQLException {
        if(connection !=null) {
            connection.close();
        }
        if(connection == null) {
            connection.isClosed();
        }
    }
}
