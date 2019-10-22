import java.util.*;
import java.io.*;

public class TreeOrder {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			inOderTraversal(result, 0);
			return result;
		}
		private class Node {
			int left;
			int right;
			int num;
			Node(int num, int left, int right) {
				this.num = num;
				this.left = left;
				this.right = right;
			}

		}

		private void inOderTraversal(ArrayList<Integer> result, int i) {
			Integer current = i;
			Stack<Node> stack = new Stack<>();

			while(stack.size() > 0 || current != -1) {
				while (current != -1) {
					stack.push(new Node(key[current], left[current], right[current]));

					current = left[current];
				}
				Node el = stack.pop();
				result.add(el.num);
				current = el.right;
			}

		}


		private void preOderTraversal(ArrayList<Integer> result, int i) {
			Integer current = i;
			Stack<Node> stack = new Stack<>();
			stack.push(new Node(key[current], left[current], right[current]));

			while(stack.size() > 0 ) {
				Node el = stack.pop();
				result.add(el.num);
				if (el.right != -1 ) {
					stack.push(new Node(key[el.right], left[el.right], right[el.right]));
				}
				if (el.left != -1 ) {
					stack.push(new Node(key[el.left], left[el.left], right[el.left]));
				}

			}

		}

		private void postOderTraversal(ArrayList<Integer> result, int i) {
			Integer current = i;
			Stack<Node> stack = new Stack<>();
			Stack<Node> print = new Stack<>();
			stack.push(new Node(key[current], left[current], right[current]));

			while(stack.size() > 0 ) {
				Node el = stack.pop();
				print.add(el);

				if (el.left != -1 ) {
					stack.push(new Node(key[el.left], left[el.left], right[el.left]));
				}
				if (el.right != -1 ) {
					stack.push(new Node(key[el.right], left[el.right], right[el.right]));
				}


			}

			while (!print.isEmpty()) {
				Node temp = print.pop();
				result.add(temp.num);
			}



		}


		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			preOderTraversal(result, 0);
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			postOderTraversal(result, 0);
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
                            new TreeOrder().run();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
