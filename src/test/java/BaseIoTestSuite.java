import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class BaseIoTestSuite {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpOutput() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    void provideInput(String data) {
        inContent = new ByteArrayInputStream(data.getBytes());
        System.setIn(inContent);
    }


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
