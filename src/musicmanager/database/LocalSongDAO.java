package musicmanager.database;

import java.sql.Connection;
import java.sql.ResultSet;
import musicmanager.musicsource.LocalSong;

public class LocalSongDAO extends DAO<LocalSong> {

    public LocalSongDAO(Connection c) {
        super(c);
        executeUpdate(SQL.CREATE_TABLE);
    }

    @Override
    public LocalSong create(LocalSong object) {
        executeUpdate(SQL.INSERT, object.path, object.title, object.artiste, object.album);
        return null;
    }

    @Override
    public LocalSong update(LocalSong object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalSong find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected LocalSong map(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static class SQL {

        public static final String INSERT = "INSERT INTO LocalSong VALUES (?, ?, ?, ?)";
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS LocalSong ("
                + "path VARCHAR(200) PRIMARY KEY,"
                + "title VARCHAR(100),"
                + "artiste VARCHAR(100),"
                + "album VARCHAR(100)"
                + ")";
    }

}
