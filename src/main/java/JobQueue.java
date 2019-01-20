import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private Worker[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    private Heap heap;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        heap = new Heap(numWorkers);

        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i].index + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new Worker[jobs.length];
        startTime = new long[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            int duration = jobs[i];
            Worker bestWorker = heap.peekMax();
            assignedWorker[i] = bestWorker;
            startTime[i] = bestWorker.nextFreeTime;
            heap.changePriority(0, bestWorker.nextFreeTime + duration);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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

    private class Heap {
        private Worker[] data;

        Heap(int numberOfWorkers) {
            data = new Worker[numberOfWorkers];
            for (int i = 0; i < numberOfWorkers; i++) {
                data[i] = new Worker(i);
            }
            buildHeap();
        }

        Worker peekMax() {
            return data[0];
        }
        void buildHeap() {
            int size = data.length - 1;
            for (int i = (size / 2); i >= 1; i--) {
                siftDown(i);

            }
        }

        void siftDown(int i) {
            int maxIndex = i;
            int l = leftChild(i);
            int size = data.length - 1;
            if (l <= size ) {
                if(data[l].nextFreeTime < data[maxIndex].nextFreeTime) {
                    maxIndex = l;
                } else if (data[l].nextFreeTime == data[maxIndex].nextFreeTime && data[l].index < data[maxIndex].index) {
                    maxIndex = l;
                }

            }
            int r = rightChild(i);
            if (r <= size) {

                if( data[r].nextFreeTime < data[maxIndex].nextFreeTime ) {
                    maxIndex = r;
                } else if ( data[r].nextFreeTime == data[maxIndex].nextFreeTime && data[r].index < data[maxIndex].index) {
                    maxIndex = r;
                }
            }
            if (i != maxIndex) {
                Worker tmp = data[maxIndex];
                data[maxIndex] = data[i];
                data[i] = tmp;
                siftDown(maxIndex);
            }
        }

        void siftUp(int i) {
            while (i > 1) {
                if (data[parent(i)].nextFreeTime > data[i].nextFreeTime) {
                    Worker tmp = data[parent(i)];
                    data[parent(i)] = data[i];
                    data[i] = tmp;
                    i = parent(i);
                } else if (data[parent(i)].nextFreeTime == data[i].nextFreeTime && data[parent(i)].index > data[i].index) {
                    Worker tmp = data[parent(i)];
                    data[parent(i)] = data[i];
                    data[i] = tmp;
                    i = parent(i);
                }

            }
        }

        void changePriority(int i, long nextFreeTime) {
            long oldP = data[i].getPriority();
            data[i].nextFreeTime = nextFreeTime;
            long nexP = data[i].getPriority();
            if (nexP > oldP) {
                siftDown(i);
            } else {
                siftUp(i);
            }

        }

        int rightChild(int i) {
            return 2 * i + 1;
        }
        int parent(int i) {
            return i / 2;
        }

        int leftChild(int i) {
            return 2 * i;
        }
    }

    private class Worker {
        long nextFreeTime;
        long index;

        public Worker(int index) {
            this.index = index;
        }

        long getPriority() {
            return nextFreeTime + index;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "nextFreeTime=" + nextFreeTime +
                    ", index=" + index +
                    '}';
        }
    }
}
