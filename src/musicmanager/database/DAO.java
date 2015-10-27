package musicmanager.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO<T> {

    protected Connection connection;

    public DAO(Connection c) {
        this.connection = c;
    }

    public abstract T create(T object);

    public abstract T update(T object);

    public abstract T find(Object id);

    public abstract void delete();

    protected void executeUpdate(String sql, Object... args) {
        try {
            prepareStatement(sql, args).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected T executeQuery(String sql, Object... args) {
        try {
            return map(prepareStatement(sql, args).executeQuery());
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return null;
        }
    }

    protected PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);

        int argIndex = 1;
        for (Object arg : args) {
            statement.setObject(argIndex, arg);
            argIndex++;
        }

        return statement;
    }

    protected abstract T map(ResultSet resultSet);

}
