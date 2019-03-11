import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class is_bst2 {
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
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public class IsBST {
        class Node {
            Long leftMax = Long.MAX_VALUE;
            Long rightMin = Long.MAX_VALUE;
            Long key;
            int left;
            int right;

            Node(Long key, int left, int right) {
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
                tree[i] = new Node(in.nextLong(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if (tree.length == 0 || tree.length == 1) {
                return true;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(tree[0]);


            while (stack.size() > 0) {
                Node el = stack.peek();
                if (el.leftMax != Long.MAX_VALUE && el.rightMin != Long.MAX_VALUE) {
                    el = stack.pop();
                    if (el.left != -1 ) {
                        ArrayList<Long> values = new ArrayList<Long>();
                        values.add(tree[el.left].key);
                        values.add(tree[el.left].rightMin);
                        values.add(tree[el.left].leftMax);
                        el.leftMax =  Collections.max(values.stream().filter(els -> els != -1).collect(Collectors.toSet()));
                    }

                    if (el.right != -1) {
                        ArrayList<Long> values = new ArrayList<Long>();
                        values.add(tree[el.right].key);
                        values.add(tree[el.right].rightMin);
                        values.add(tree[el.right].leftMax);
                        el.rightMin = Collections.min(values.stream().filter(els -> els != -1).collect(Collectors.toSet()));
                    }
                    continue;
                }


                if (el.left != -1 ) {
                    stack.push(tree[el.left]);
                    el.rightMin = el.key;
                    el.leftMax = -1l;
                } else {
                    el.leftMax = -1l;
                }

                if (el.right != -1 ) {
                    stack.push(tree[el.right]);
                    el.rightMin = el.key;
                    el.leftMax = -1l;
                } else {
                    el.rightMin = el.key;
                }
            }


            return tree[0].leftMax < tree[0].key && tree[0].rightMin >= tree[0].key;
        }
    }

    static public void main(String[] args) throws IOException {
        new is_bst2().run();
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
