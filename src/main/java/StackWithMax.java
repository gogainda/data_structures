import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                if (maxStack.isEmpty() || maxStack.peek() <= value) {
                    maxStack.push(value);
                }
                stack.push(value);
            } else if ("pop".equals(operation)) {
                int popValue = stack.peek();
                if (maxStack.peek() == popValue) {
                    maxStack.pop();
                }
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(maxStack.peek());
            }
        }
    }

    static public void main(String[] args) throws IOException {
//        TodoItem item = new TodoItem("hello", LocalDate.now());

    }
}
