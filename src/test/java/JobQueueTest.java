import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JobQueueTest extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "2 5\n" +
                "1 2 3 4 5";
        provideInput(input);

        JobQueue.main(new String[0]);

        String expected = "0 0\n" +
                "1 0\n" +
                "0 1\n" +
                "1 2\n" +
                "0 4\n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase2() throws IOException {
        final String input = "4 20\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
        provideInput(input);

        JobQueue.main(new String[0]);

        String expected = "0 0\n" +
                "1 0\n" +
                "2 0\n" +
                "3 0\n" +
                "0 1\n" +
                "1 1\n" +
                "2 1\n" +
                "3 1\n" +
                "0 2\n" +
                "1 2\n" +
                "2 2\n" +
                "3 2\n" +
                "0 3\n" +
                "1 3\n" +
                "2 3\n" +
                "3 3\n" +
                "0 4\n" +
                "1 4\n" +
                "2 4\n" +
                "3 4\n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase3() throws IOException {
        final String input = "5 3\n" +
                "43 23 5";
        provideInput(input);

        JobQueue.main(new String[0]);

        String expected = "0 0\n" +
                "1 0\n" +
                "2 0\n";
        Assertions.assertEquals(expected, outContent.toString());
    }
}
