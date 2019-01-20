import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackWithMaxTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpOutput() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    private void provideInput(String data) {
        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);
    }


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testCase1() throws IOException {
        final String input = "5\n" +
                "push 2\n" +
                "push 1\n" +
                "max\n" +
                "pop\n" +
                "max";
        provideInput(input);

        StackWithMax.main(new String[0]);

        String expected = "2\n" +
                "2\n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase2() throws IOException {
        final String input = "10\n" +
                "push 2\n" +
                "push 3\n" +
                "push 9\n" +
                "push 7\n" +
                "push 2\n" +
                "max\n" +
                "max\n" +
                "max\n" +
                "pop\n" +
                "max";
        provideInput(input);

        StackWithMax.main(new String[0]);

        String expected = "9\n" +
                "9\n" +
                "9\n" +
                "9\n";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase3() throws IOException {
        final String input = "3\n" +
                "push 1\n" +
                "push 7\n" +
                "pop";
        provideInput(input);

        StackWithMax.main(new String[0]);

        String expected = "";
        Assertions.assertEquals(expected, outContent.toString());
    }

    @Test
    public void testCase4() throws IOException {
        final String input = "3\n" +
                "push 1\n" +
                "push 7\n" +
                "pop";
        provideInput(input);

        StackWithMax.main(new String[0]);

        String expected = "";
        Assertions.assertEquals(expected, outContent.toString());
    }


}
