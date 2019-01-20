import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        buildHeap();
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    private void buildHeap() {
        int size = data.length - 1;
        for (int i = (size / 2); i >= 1; i--) {
            siftDown(i);

        }
    }

    private void siftDown(int i) {
        int maxIndex = i;
        int l = leftChild(i);
        int size = data.length - 1;
        if (l <= size && data[l] < data[maxIndex]) {
            maxIndex = l;
        }
        int r = rightChild(i);
        if (r <= size && data[r] < data[maxIndex]) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            swaps.add(new Swap(i - 1, maxIndex - 1));
            int tmp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = tmp;
            siftDown(maxIndex);
        }
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private int leftChild(int i) {
        return 2 * i;
    }


    private class Heap {
        private final int[] data;

        Heap(int args[]) {
            this.data = args;

        }

    }
}
