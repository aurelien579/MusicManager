package musicmanager.musicsource;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import musicmanager.database.DAOFactory;

public class FolderMusicSource extends MusicSource {

    private final File root;

    public FolderMusicSource(String path) {
        root = new File(path);
    }

    @Override
    public void initializeContent() {
        if (root.isDirectory()) {
            parseDirectory(root);
            for (AbstractSong s : songs) {
                LocalSong song = (LocalSong) s;
                DAOFactory.getInstance().localSongDAO.create(song);
            }
        } else if (root.isFile()) {
            parseFile(root);
        } else {
            System.err.println("File is of incorect type: " + root.toString());
        }
    }

    private void parseDirectory(File path) {
        for (File directory : path.listFiles(new DirectoryFileFilter())) {
            parseDirectory(directory);
        }

        for (File file : path.listFiles(new MusicFileFilter())) {
            parseFile(file);
        }
    }

    private void parseFile(File file) {
        songs.add(new LocalSong(file.getName(), "artiste", "album", file));
    }

    @Override
    public String getSourceType() {
        return MusicSource.LOCAL_SOURCE_TYPE;
    }

    @Override
    public String getLabel() {
        return root.getName();
    }
}

class DirectoryFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }

}

class MusicFileFilter implements FileFilter {

    private static final List<String> extensions = Arrays.asList(".mp3");

    @Override
    public boolean accept(File file) {
        String p = file.getAbsolutePath();
        int pos = p.lastIndexOf('.');
        if (pos > 0) {
            return extensions.contains(p.substring(pos));
        } else {
            return false;
        }
    }

}
