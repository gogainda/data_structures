import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HashSubstringTest extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "aba\n" +
                "abacaba";
        provideInput(input);

        HashSubstring.main(new String[0]);

        String expected = "0 4";
        Assertions.assertEquals(expected, outContent.toString());
    }


}
