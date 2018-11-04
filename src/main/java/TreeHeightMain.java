import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeHeightMain {
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

    public class TreeHeight {
        int n;
        int parent[];
        Node root;
        Node nodes[];
        int level = 0;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            buildTree();             // Replace this code with a faster implementation
            int maxHeight = postOverTraversal(root);
            return maxHeight;
        }

        private int postOverTraversal(Node root) {
            int max = -1;
            if (root == null) {
                return 0;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node next = queue.poll();

                for (Node dd :
                        next.children) {
                    dd.level = next.level + 1;
                    if (dd.level > max) {
                        max = dd.level;
                    }
                    queue.add(dd);
                }

            }




            return max + 1;


        }

        private void buildTree() {
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int childIndex = 0; childIndex < n; childIndex++) {
                int parentIndex = parent[childIndex];
                if (parentIndex == -1) {
                    root = nodes[childIndex];

                } else {
                    Node parent = nodes[parentIndex];
                    parent.addChild(nodes[childIndex]);
                }
            }
        }
    }

    private class Node {
        List<Node> children = new ArrayList<Node>(1);
        int idx;
        int level  = 0;

        public Node(int idx) {
            this.idx = idx;
        }

        void addChild(Node node) {
            children.add(node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "children=" + children.size() +
                    "idx=" + idx + "}";
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new TreeHeightMain().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
