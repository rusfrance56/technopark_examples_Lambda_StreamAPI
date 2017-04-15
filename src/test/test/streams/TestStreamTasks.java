package streams;

import com.helpfulClasses.music.Album;
import com.helpfulClasses.music.Track;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestStreamTasks {
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
    public void testStreamAddUp() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Assert.assertEquals(15, addUp(numbers));
    }

    @Test
    public void testStreamGetTotalTracks() {
        Assert.assertTrue(6 == getTotalTracks(albums));
    }

    @Test
    public void testStreamGetUpperLetterCount() {
        Assert.assertTrue(2 == getUpperLetterCount("Hello! World"));
    }

    @Test
    public void testStreamGetStringOfMaxUpperLetterCount() {
        Assert.assertEquals("WWfsfWW3", getStringOfMaxUpperLetterCount(Arrays.asList("WWssWsrrra1", "WsW2", "WWfsfWW3")));
    }

    @Test
    public void testStreamGetNamesAndLength() {
        List<String> trackNamesAndLength = new ArrayList<>();
        trackNamesAndLength.add("name: " + "first Track" + " length: " + 30);
        trackNamesAndLength.add("name: " + "first Track2" + " length: " + 90);
        trackNamesAndLength.add("name: " + "first Track3" + " length: " + 70);
        Assert.assertEquals(trackNamesAndLength, getTrackNamesAndLength(trackList));
    }

    private static int addUp(Stream<Integer> numbers) {
        return numbers.reduce((sum, nextNum) -> sum + nextNum).get();
    }

    private static List<String> getTrackNamesAndLength(List<Track> tracks) {
        return tracks.stream().map(track -> "name: " + track.getName() + " length: " + track.getLength()).collect(toList());
    }

    private static int getTotalTracks(List<Album> albums) {
        return new Long(albums.stream().flatMap(album -> album.getTrackList().stream()).count()).intValue();
    }

    private static int getUpperLetterCount(String input) {
        return (int) input.chars().filter(Character::isUpperCase).count();
    }
    private static String getStringOfMaxUpperLetterCount(List<String> input) {
        //my realisation
        /*return input.stream().max((s1, s2) -> {
            long count = s1.chars().filter(Character::isUpperCase).count();
            long count2 = s2.chars().filter(Character::isUpperCase).count();
            //return count > count2 ? 1 : (count == count2 ? 0 : -1);
            return Long.compare(count, count2);
        }).get();*/

        //short realisation
        return input.stream().max(Comparator.comparingLong(o -> o.chars().filter(Character::isUpperCase).count())).get();
    }
}
