package musicmanager.musicsource;

import java.util.ArrayList;

public abstract class MusicSource {

    public static final String LOCAL_SOURCE_TYPE = "Local Source";
    public final ArrayList<AbstractSong> songs;

    public MusicSource() {
        songs = new ArrayList();
    }

    public abstract void initializeContent();

    public abstract String getSourceType();

    public abstract String getLabel();

    @Override
    public String toString() {
        return getLabel();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }
}
