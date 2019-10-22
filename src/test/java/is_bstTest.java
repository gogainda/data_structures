import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class is_bstTest  extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "3\n" +
                "2 1 2\n" +
                "1 -1 -1\n" +
                "3 -1 -1";
        provideInput(input);

        is_bst.main(new String[0]);

        String expected = "INCORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase2() throws IOException {
        final String input = "0";
        provideInput(input);

        is_bst.main(new String[0]);

        String expected = "INCORRECT";
        Assertions.assertEquals(expected, outContent.toString());
    }
}