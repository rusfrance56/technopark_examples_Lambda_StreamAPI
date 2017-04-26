package streams;

import com.helpfulClasses.music.Artist;
import com.util.TestsBase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TestsChapter5Exercise extends TestsBase{

    @Test
    public void getLongestName() {
        Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        Stream<String> names2 = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        Stream<String> names3 = Stream.of("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        //через max
        /*Optional<Artist> artist = albums.stream().map(album -> album.getArtist())
                .max(Comparator.comparingInt(artist1 -> artist1.getName().length()));*/
        Optional<String> max = names.max(Comparator.comparingInt(artist1 -> artist1.length()));

        //collect
        /*Artist artist2 = albums.stream().map(album -> album.getArtist())
                .collect(Collectors.maxBy(Comparator.comparing(artist1 -> artist1.getName().length())))
                .orElseThrow(RuntimeException::new);*/
        Optional<String> collect = names2.collect(maxBy(Comparator.comparing(artist1 -> artist1.length())));

        //reduce
        /*Optional<Artist> reduce = albums.stream().map(album -> album.getArtist())
                .reduce((acc, artist1) -> artist1.getName().length() > acc.getName().length() ? artist1 : acc);*/
        Optional<String> reduce = names3.reduce((acc, artist1) -> artist1.length() > acc.length() ? artist1 : acc);

        //Assert.assertEquals("Eminem wwwwwwwwwwwww", artist.get().getName());
        //Assert.assertEquals("Eminem wwwwwwwwwwwww", artist2.getName());
        //Assert.assertEquals("Eminem wwwwwwwwwwwww", reduce.get().getName());
        Assert.assertEquals("Stuart Sutcliffe", max.get());
        Assert.assertEquals("Stuart Sutcliffe", collect.get());
        Assert.assertEquals("Stuart Sutcliffe", reduce.get());
    }

    @Test
    public void getWordCount() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Long> collect = names.collect(groupingBy(name -> name, counting()));
        System.out.println();
    }
}
