import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class is_bst2Test extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "3\n" +
                "2 1 2\n" +
                "1 -1 -1\n" +
                "2 -1 -1";
        provideInput(input);

        is_bst2.main(new String[0]);

        String expected = "INCORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }
    @Test
    public void testCas21() throws IOException {
        final String input = "3\n" +
                "2 1 2\n" +
                "2 -1 -1\n" +
                "3 -1 -1";
        provideInput(input);

        is_bst2.main(new String[0]);

        String expected = "INCORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }
    @Test
    public void testCas22() throws IOException {
        final String input = "0";
        provideInput(input);

        is_bst2.main(new String[0]);

        String expected = "CORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }
    @Test
    public void testCas23() throws IOException {
        final String input = "1\n" +
                "2147483647 -1 -1";
        provideInput(input);

        is_bst2.main(new String[0]);

        String expected = "CORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase3() throws IOException {
        final String input = "3\n" +
                "2 1 2\n" +
                "2 -1 -1\n" +
                "3 -1 -1";
        provideInput(input);

        is_bst2.main(new String[0]);

        String expected = "CORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase2() throws IOException {
        final String input = "14\n" +
                "10 1 2\n" +
                "0 3 4\n" +
                "20 5 6\n" +
                "-5 7 8\n" +
                "5 9 10\n" +
                "15 11 12\n" +
                "20 -1 13\n" +
                "-10 -1 -1\n" +
                "-5 -1 -1\n" +
                "2 -1 -1\n" +
                "5 -1 -1\n" +
                "10 -1 -1\n" +
                "15 -1 -1\n" +
                "25 -1 -1";
        provideInput(input);

        is_bst2.main(new String[0]);

        String expected = "CORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }
}