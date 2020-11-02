package domain.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionManager {
    public Connection connection;
    private static DbConnectionManager dbConnectionManager_instance = null;

    private DbConnectionManager(String dbURL)
    {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:62021/2TX36";
        try {
            Class.forName("domain.db.util.Secret");
            Secret.setPass(properties);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class domain.db.util.Secret with credentials not found!");
        }

        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode", "prefer");

        try
        {
            System.out.println("Connecting to database...");
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(dbURL, properties);
            System.out.println("Done");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getException().getMessage());
        }
        catch (SQLException e)
        {
            System.out.println("Connection troubles");
            System.out.println(e.getErrorCode());
        }
    }

    public static DbConnectionManager getInstance(String dbURL) {
        if (dbConnectionManager_instance == null) {
            dbConnectionManager_instance = new DbConnectionManager(dbURL);
        }
        return dbConnectionManager_instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
