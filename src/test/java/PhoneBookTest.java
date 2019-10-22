import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PhoneBookTest extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "12\n" +
                "add 911 police\n" +
                "add 76213 Mom\n" +
                "add 17239 Bob\n" +
                "find 76213\n" +
                "find 910\n" +
                "find 911\n" +
                "del 910\n" +
                "del 911\n" +
                "find 911\n" +
                "find 76213\n" +
                "add 76213 daddy\n" +
                "find 76213";
        provideInput(input);

        PhoneBook.main(new String[0]);

        String expected = "Mom\n" +
                "not found\n" +
                "police\n" +
                "not found\n" +
                "Mom\n" +
                "daddy\n";
        Assertions.assertEquals(expected, outContent.toString());
    }
}
