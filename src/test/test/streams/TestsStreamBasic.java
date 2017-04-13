package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestsStreamBasic {

    @Test
    public void testStream() {
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");

        Assert.assertEquals("Foo", strings.stream().findFirst().get());
    }

    @Test
    public void testStream2() {
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");

        Assert.assertEquals(Arrays.asList("Bar", "Baz")
                , strings.stream().filter(s -> s.startsWith("B")).collect(Collectors.toList()));
        //TODO or we can put result into custom list: strings.stream().collect(Collectors.toCollection(() -> strings));
    }

    @Test
    public void testStream3() {
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");

        Assert.assertEquals(Arrays.asList(3, 3, 3)
                , strings.stream().map(s -> s.length()).collect(Collectors.toList()));
    }

    @Test
    public void testStream4() {
        List<String> strings = Arrays.asList("Foo", "Barr", "Bazzz");

        Assert.assertTrue(5 ==
                 strings.stream().map(s -> s.length()).reduce((i1, i2) -> i1 > i2 ? i1 : i2).get());
    }

    @Test
    public void testStream5() {
        List<String> strings = Arrays.asList("Foo,Barr,Bazzz");

        Assert.assertEquals(Arrays.asList("Foo", "Barr", "Bazzz"),
                strings.stream().flatMap(s -> Arrays.stream(s.split(","))).collect(Collectors.toList()));
    }

    @Test
    public void testStream6() {
        List<String> strings = Arrays.asList("Foo", "Barr", "Bazzz", "Bazzz", "Bazzz", "Bazzz");

        Assert.assertEquals(Arrays.asList("Foo", "Barr", "Bazzz"),
                 strings.stream().distinct().collect(Collectors.toList()));
    }

    @Test
    public void testStream7() {
        List<String> strings = Arrays.asList("Barr1", "Bazzz2", "Bazzza4", "Bazzz3");

        Assert.assertEquals(Arrays.asList("Barr1", "Bazzz2", "Bazzz3", "Bazzza4"),
                 strings.stream()
                         .sorted( (s1, s2) -> s1.length() > s2.length() ? 1 : (s1.length() < s2.length() ? -1 : 0))
                         .collect(Collectors.toList()));
    }

    @Test
    public void testStream8() {
        List<String> strings = Arrays.asList("Barr1", "Bazzz2", "Bazzza4", "Bazzz3");

        Assert.assertEquals("!Barr1:Bazzz2:Bazzza4:Bazzz3!",
                strings.stream()
                        .collect(Collectors.joining(":", "!", "!")));
    }
}
