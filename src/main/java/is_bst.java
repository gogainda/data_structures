import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class is_bst {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            boolean result = true;
            Integer start = Integer.MIN_VALUE;
            if (tree.length == 0) {
                return true;
            }
            Node current = tree[0];
            Stack<Node> stack = new Stack<>();

            while (stack.size() > 0 || current != null) {
                while (current != null) {
                    stack.push(current);

                    if (current.left == -1) {
                        current = null;
                    } else {
                        current = tree[current.left];
                    }

                }
                Node el = stack.pop();
                if (el.key < start) {
                    result = false;
                }
                start = el.key;
                if (el.right == -1) {
                    current = null;
                } else {
                    current = tree[el.right];
                }
            }
            return result;
        }
    }

    static public void main(String[] args) throws IOException {
                    new is_bst().run();
    }

    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
