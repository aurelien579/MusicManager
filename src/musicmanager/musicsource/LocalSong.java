package musicmanager.musicsource;

import java.io.File;
import java.io.Serializable;

public class LocalSong extends AbstractSong implements Serializable {

    private static final long serialVersionUID = 1L;
    public final String path;

    public LocalSong(String title, String artiste, String album, File file) {
        super(title, artiste, album);
        path = file.getAbsolutePath();
    }
}
