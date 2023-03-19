package model;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private final String db = "pruebaIBM";
    private final String url = "jdbc:mysql://locahost:3306/";
    private final String user = "root";
    private final String password = "";

    private static Conexion dataSource;
    private BasicDataSource basicDataSource = null;

    public Conexion() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url + db);
    }

    public static Conexion getInstance() {
        if (dataSource == null) {
            dataSource = new Conexion();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.basicDataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
