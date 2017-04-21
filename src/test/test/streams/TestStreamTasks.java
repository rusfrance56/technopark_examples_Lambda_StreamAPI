package streams;

import com.helpfulClasses.music.Album;
import com.helpfulClasses.music.Artist;
import com.helpfulClasses.music.Track;
import com.util.TestsBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestStreamTasks extends TestsBase {


    @Test
    public void testAddUp() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Assert.assertEquals(15, addUp(numbers));
    }

    @Test
    public void testGetTotalTracks() {
        Assert.assertTrue(9 == getTotalTracks(albums));
    }

    @Test
    public void testGetUpperLetterCount() {
        Assert.assertTrue(2 == getUpperLetterCount("Hello! World"));
    }

    @Test
    public void testGetStringOfMaxUpperLetterCount() {
        Assert.assertEquals("WWfsfWW3", getStringOfMaxUpperLetterCount(Arrays.asList("WWssWsrrra1", "WsW2", "WWfsfWW3")));
    }

    @Test
    public void testGetNamesAndLength() {
        List<String> trackNamesAndLength = new ArrayList<>();
        trackNamesAndLength.add("name: " + "first Track" + " length: " + 30);
        trackNamesAndLength.add("name: " + "first Track2" + " length: " + 90);
        trackNamesAndLength.add("name: " + "first Track3" + " length: " + 70);
        Assert.assertEquals(trackNamesAndLength, getTrackNamesAndLength(trackList));
    }

    @Test
    public void testGetBiggestGroup() {
        Artist artist1 = new Artist("Limp Bizkit");
        artist1.setMembers(Arrays.asList("Fred Durst", "Jordan", "Chan"));
        Assert.assertEquals(artist1, getBiggestGroup(artists).get());
    }

    @Test
    public void testJoining() {
        Artist artist1 = new Artist("Limp Bizkit");
        artist1.setMembers(Arrays.asList("Fred Durst", "Jordan", "Chan"));

        String temp = "{Fred Durst,Jordan,Chan}";
        Assert.assertEquals(temp, artist1.getMembers().stream().collect(joining(",", "{", "}")));
    }

    @Test
    public void testGetAVGGroup() {
        Assert.assertTrue(3 == getAvgGroup(albums).get());
    }

    @Test
    public void testBandsAndSoloCheck() {
        Map<Boolean, List<Artist>> collect = artists.stream().collect(partitioningBy(Artist::isSolo));
        Assert.assertEquals(1 , collect.get(true).size());
        Assert.assertEquals(2 , collect.get(false).size());
    }

    @Test
    public void testGroupByMusician() {
        Map<Artist, List<Album>> collect = albums.stream().collect(groupingBy(album -> album.getArtist()));
        Assert.assertEquals(2, collect.size());
    }

    @Test
    public void testNumberOfAlbums() {
        Map<Artist, Long> collect = albums.stream().collect(groupingBy(album -> album.getArtist(), counting()));
        //TODO assert
    }

    @Test
    public void testNameOfAlbums() {
        Map<Artist, List<String>> collect = albums.stream()
                .collect(groupingBy(album -> album.getArtist(), mapping(album -> album.getName(), toList())));
        //TODO assert
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

    public Optional<Artist> getBiggestGroup(List<Artist> artists) {
        Function<Artist, Integer> function = artist -> artist.getMembers().size();
        return artists.stream().collect(maxBy(Comparator.comparing(function)));
        //return artists.stream().max(Comparator.comparing(function));
    }

    public Optional<Double> getAvgGroup(List<Album> albums) {
        Double avg = albums.stream().collect(averagingInt(album -> album.getTrackList().size()));
        return Optional.of(avg);
    }
}
