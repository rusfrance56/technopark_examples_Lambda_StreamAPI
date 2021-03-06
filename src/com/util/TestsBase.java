package com.util;

import com.helpfulClasses.music.Album;
import com.helpfulClasses.music.Artist;
import com.helpfulClasses.music.Track;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class TestsBase {
    public static List<Album> albums;
    public static List<Track> trackList;
    public static List<Track> trackList2;
    public static List<Track> trackList3;
    private static final List<Track> trackList4;
    public static List<Artist> artists;

    /*@BeforeClass
        public static void init() {*/
    static {
        artists = new ArrayList<>();
        Artist artist = new Artist("The Beatles");
        artist.setMembers(Arrays.asList("McCartny", "Lenon"));
        artists.add(artist);

        Artist artist1 = new Artist("Limp Bizkit");
        artist1.setMembers(Arrays.asList("Fred Durst", "Jordan", "Chan"));
        artists.add(artist1);

        Artist artist2 = new Artist("Eminem");
        artist2.setMembers(Arrays.asList("Marshal Matters"));
        artists.add(artist2);

        Artist artist3 = new Artist("Eminem wwwwwwwwwwwww");
        artist3.setMembers(Arrays.asList("Marshal Matters"));
        artists.add(artist3);

        albums = new ArrayList<>();
        Album album = new Album("first album", artist2);
        trackList = album.getTrackList();
        trackList.add(new Track("first Track", 30));
        trackList.add(new Track("first Track2", 90));
        trackList.add(new Track("first Track3", 70));
        Album album2 = new Album("second album", artist1);
        trackList2 = album2.getTrackList();
        trackList2.add(new Track("first2 Track", 30));
        trackList2.add(new Track("first2 Track2", 90));
        trackList2.add(new Track("first2 Track3", 70));
        Album album3 = new Album("third album", artist2);
        trackList3 = album3.getTrackList();
        trackList3.add(new Track("first2 Track", 30));
        trackList3.add(new Track("first2 Track2", 90));
        trackList3.add(new Track("first2 Track3", 70));
        Album album4 = new Album("third album", artist3);
        trackList4 = album4.getTrackList();
        trackList4.add(new Track("first2 Track", 30));
        trackList4.add(new Track("first2 Track2", 90));
        trackList4.add(new Track("first2 Track3", 70));
        albums.add(album);
        albums.add(album2);
        albums.add(album3);
        albums.add(album4);
    }
    /*}*/
}
