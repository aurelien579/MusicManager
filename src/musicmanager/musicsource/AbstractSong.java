package musicmanager.musicsource;

public class AbstractSong {

    public final String title;
    public final String artiste;
    public final String album;

    public AbstractSong(String title, String artiste, String album) {
        this.title = title;
        this.artiste = artiste;
        this.album = album;
    }

    @Override
    public String toString() {
        return title;
    }

}
