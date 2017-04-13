package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestsStreamLazy {

    @Test
    public void testStream() {
        List<String> strings = Arrays.asList("Bar", "Bazzz2", "Baz", "Bazzz3");
        //Assert.assertEquals(Arrays.asList("Bar", "Baz"),
                strings.stream()
                        .filter(s -> s.length()==3).forEach(s -> System.out.println(s.concat("1")));
                        //.collect(Collectors.toList()));
    }
}
