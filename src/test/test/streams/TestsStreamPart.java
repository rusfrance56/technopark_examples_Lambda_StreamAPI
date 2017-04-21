package streams;

import com.util.TestsBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TestsStreamPart extends TestsBase {

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

    @Test
    public void testStreamStatistic() {
        IntSummaryStatistics intSummaryStatistics = trackList.stream().mapToInt(track -> track.getLength()).summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                intSummaryStatistics.getMax(),
                intSummaryStatistics.getMin(),
                intSummaryStatistics.getAverage(),
                intSummaryStatistics.getSum());
    }
}
