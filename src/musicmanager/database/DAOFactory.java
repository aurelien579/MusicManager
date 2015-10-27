package musicmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOFactory {

    private static DAOFactory instance;
    private Connection connection;

    public LocalSongDAO localSongDAO;

    private DAOFactory() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");

            localSongDAO = new LocalSongDAO(connection);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }

        return instance;
    }

}
