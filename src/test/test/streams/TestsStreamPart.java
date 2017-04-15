package streams;

import com.helpfulClasses.music.Album;
import com.helpfulClasses.music.Track;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TestsStreamPart {

    private static List<Album> albums;
    private static List<Track> trackList;
    private static List<Track> trackList2;

    @BeforeClass
    public static void init() {
        albums = new ArrayList<>();
        Album album = new Album("first album");
        trackList = album.getTrackList();
        trackList.add(new Track("first Track", 30));
        trackList.add(new Track("first Track2", 90));
        trackList.add(new Track("first Track3", 70));
        Album album2 = new Album("first album");
        trackList2 = album2.getTrackList();
        trackList2.add(new Track("first2 Track", 30));
        trackList2.add(new Track("first2 Track2", 90));
        trackList2.add(new Track("first2 Track3", 70));
        albums.add(album);
        albums.add(album2);
    }

    @Test
    public void testStream() {
        List<String> strings = Arrays.asList("Bar", "Bazzz2", "Baz", "Bazzz3");
        Assert.assertEquals(2,
                strings.stream()
                        .filter(s -> {
                            System.out.println(s);
                            return s.length() == 3;
                        }).count());
    }

    @Test
    public void testStream2() {
        List<String> strings = Stream.of("Bar", "Bazzz2", "Baz", "Bazzz3").collect(toList());
        Assert.assertEquals(Arrays.asList("BAR", "BAZZZ2", "BAZ", "BAZZZ3"),
                strings.stream().map(String::toUpperCase).collect(toList())
        );
    }

    @Test
    public void testStream3() {
        List<List<String>> strings = Stream.of(Arrays.asList("Bar", "Bazzz2"), Arrays.asList("Baz", "Bazzz3")).collect(toList());
        Assert.assertEquals(Arrays.asList("Bar", "Bazzz2", "Baz", "Bazzz3"),
                strings.stream().flatMap(s -> s.stream()).collect(toList())
        );
    }

    @Test
    public void testStreamMin() {
        List<String> strings = Arrays.asList("Bar", "Bazzz2", "Baz", "Bazzz3");
        Assert.assertEquals(new String("Bar"),
                strings.stream().min(Comparator.comparing(s -> s.length())).get());
    }

    @Test
    public void testStreamReduce() {
        List<String> strings = Arrays.asList("Bar", "Bazzz2", "Baz", "Bazzz3");
        Assert.assertEquals(new String("BarBazzz2BazBazzz3"),
                strings.stream().reduce((acc, fresh) -> acc + fresh).get());
    }

    @Test
    public void testStreamRefactoring() {
        Set<String> trackNames = new HashSet<>();
        //old realisation
        /*for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    trackNames.add(track.getName());
                }
            }
        }*/

        //new realisation Java8 streams
        trackNames = albums.stream().flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(toSet());

        Set<String> trackNamesCheck = new HashSet<>();
        trackNamesCheck.add("first Track2");
        trackNamesCheck.add("first Track3");
        trackNamesCheck.add("first2 Track2");
        trackNamesCheck.add("first2 Track3");
        Assert.assertEquals(trackNamesCheck, trackNames);
    }
}
