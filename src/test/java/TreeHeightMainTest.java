import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class TreeHeightMainTest {
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
				"4 -1 4 1 1";
		provideInput(input);

		TreeHeightMain.main(new String[0]);

		String expected = "Success";
		Assertions.assertEquals(expected, outContent.toString());
	}
}
