package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
    private static DBConnect instance;
    private Connection connection;
    private String url;
    private String user;
    private String password;

    private DBConnect() throws SQLException {
        Properties props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            this.url = props.getProperty("url");
            this.user = props.getProperty("user");
            this.password = props.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.connection = DriverManager.getConnection(url, user, password);
    }

    public static DBConnect getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnect();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBConnect();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

