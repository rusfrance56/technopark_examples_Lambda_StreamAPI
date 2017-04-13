package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestsStreamPart {

    @Test
    public void testStream() {
        List<String> strings = Arrays.asList("Bar", "Bazzz2", "Baz", "Bazzz3");
        Assert.assertEquals(2,
                strings.stream()
                        .filter(s -> {
                            System.out.println(s);
                            return s.length()==3;
                        }).count());
    }

    @Test
    public void testStream2() {
        List<String> strings = Stream.of("Bar", "Bazzz2", "Baz", "Bazzz3").collect(toList());
        Assert.assertEquals(Arrays.asList("BAR","BAZZZ2", "BAZ", "BAZZZ3"),
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
}
