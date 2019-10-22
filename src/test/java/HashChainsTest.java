import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashChainsTest extends BaseIoTestSuite {
    @Test
    public void testCase1() throws IOException {
        final String input = "5\n" +
                "12\n" +
                "add world\n" +
                "add HellO\n" +
                "check 4\n" +
                "find World\n" +
                "find world\n" +
                "del world\n" +
                "check 4\n" +
                "del HellO\n" +
                "add luck\n" +
                "add GooD\n" +
                "check 2\n" +
                "del good";
        provideInput(input);

        HashChains.main(new String[0]);

        String expected = "HellO world \n" +
                "no\n" +
                "yes\n" +
                "HellO \n" +
                "GooD luck \n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase2() throws IOException {
        final String input = "4\n" +
                "8\n" +
                "add test\n" +
                "add test\n" +
                "find test\n" +
                "del test\n" +
                "find test\n" +
                "find Test\n" +
                "add Test\n" +
                "find Test";
        provideInput(input);

        HashChains.main(new String[0]);

        String expected = "HellO world \n" +
                "no\n" +
                "yes\n" +
                "HellO \n" +
                "GooD luck \n";
        Assertions.assertEquals(expected, outContent.toString());
    }
}
