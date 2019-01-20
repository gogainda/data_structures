import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class CheckBracketsTest extends BaseIoTestSuite {



    @Test
    public void testCase1() throws IOException {
        final String input = "[]";
        provideInput(input);

        CheckBrackets.main(new String[0]);

        String expected = "Success";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase2() throws IOException {
        final String input = "[({})]";
        provideInput(input);

        CheckBrackets.main(new String[0]);

        String expected = "Success";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase3() throws IOException {
        final String input = "{";
        provideInput(input);

        CheckBrackets.main(new String[0]);

        String expected = "1";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase4() throws IOException {
        final String input = "{[}";
        provideInput(input);

        CheckBrackets.main(new String[0]);

        String expected = "3";
        Assertions.assertEquals(expected, outContent.toString());
    }


}