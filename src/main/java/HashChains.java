import java.io.*;
import java.util.*;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    private Map<Integer, LinkedList<String>> elems = new HashMap<>();
    // for hash function
    private int bucketCount;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println(wasFound ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
        // out.flush();
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":

                if (!elems.containsKey(hashFunc(query.s)))
                    elems.put(hashFunc(query.s), new LinkedList<>(Arrays.asList(query.s)));
                else {
                    LinkedList<String> prevEl = elems.get(hashFunc(query.s));
                    if (!prevEl.contains(query.s)) {
                        prevEl.addFirst(query.s);
                        elems.put(hashFunc(query.s), prevEl);
                    }
                }
                break;
            case "del":
                if (elems.containsKey(hashFunc(query.s))) {
                    LinkedList<String> prevEl = elems.get(hashFunc(query.s));
                    prevEl.remove(query.s);
                    elems.put(hashFunc(query.s), prevEl);
                }

                break;
            case "find":
                if (elems.containsKey(hashFunc(query.s))) {
                    LinkedList<String> list = elems.get(hashFunc(query.s));
                    writeSearchResult(list.contains(query.s));
                } else {
                    out.print("no \n");
                }

                break;
            case "check":
                if (elems.containsKey(query.ind)) {
                    LinkedList<String> list = elems.get(query.ind);
                    out.print(String.join(" ", list) + " \n");
                } else {
                    out.print(" \n");
                }
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }

    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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
}
