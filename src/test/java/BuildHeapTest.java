import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeapTest extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "5\n" +
                "5 4 3 2 1";
        provideInput(input);

        BuildHeap.main(new String[0]);

        String expected = "Success";
        Assertions.assertEquals(expected, outContent.toString());
    }
}
