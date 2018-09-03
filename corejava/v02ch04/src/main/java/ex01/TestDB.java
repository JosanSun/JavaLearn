package ex01;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * @Author : zs.sun
 * @Date : 2018/8/12 22:58
 * @Package : ex01
 * @ProjectName: corejava
 * @Description: This program tests that the database and the JDBC driver are correctly configured.
 */
public class TestDB {
    public static void main(String[] args) throws IOException {
        try
        {
            runTest();
        }
        catch (SQLException ex)
        {
            for(Throwable t : ex)
            {
                t.printStackTrace();
            }
        }

    }

    /**
     * Runs a test by creating a table, adding a value, showing the table contents, and removing
     * the table
     */
    public static void runTest() throws SQLException, IOException
    {
        try(Connection conn = getConnection())
        {
            Statement stat = conn.createStatement();

            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");

            try(ResultSet result = stat.executeQuery("SELECT * FROM Greetings"))
            {
                if(result.next())
                {
                    System.out.println(result.getString(1));
                }
            }
        }
    }

    /**
     * Get a connection from the properties specified in the file database.properties
     */
    public static Connection getConnection() throws SQLException, IOException
    {
        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("v02ch04/src/main/resources/database.properties")))
        {
            props.load(in);
        }
        String drivers = props.getProperty("jdbc.drivers");
        if(null != drivers)
        {
            System.setProperty("jdbc.drivers", drivers);
        }

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }
}


