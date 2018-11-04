import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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
            if (root == null) {
                return 0;
            }
            if (root.children.isEmpty()) {
                return 1;
            }
            List<Integer> res = new ArrayList<>(1);
            for (Node dd :
                    root.children) {
                res.add(postOverTraversal(dd));
            }


            return Collections.max(res) + 1;


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
        new TreeHeightMain().run();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
