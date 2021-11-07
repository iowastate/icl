import java.util.*;
import java.io.*;

public class A {

	ArrayList<ArrayList<Integer>> E;
	int[] w = new int[(int) 1e4 + 7];
	int[] vis = new int[(int) 1e4 + 7];
	int sum;

	public static void main(String[] args) {
		A a = new A();
		FastScanner fs = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int t = fs.nextInt();
		for (int tt = 0; tt < t; tt++) {
			int n = fs.nextInt();
			int m = fs.nextInt();
			a.E = new ArrayList<>();
			a.w = new int[(int) 1e4 + 7];
			a.vis = new int[(int) 1e4 + 7];
			for (int i = 0; i < n; i++) {
				a.w[i] = fs.nextInt();
				a.E.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				a.addEdge(fs.nextInt(), fs.nextInt());
			}

			boolean ok = true;
			for (int i = 0; i < n; i++) {
				if (a.vis[i] != 1) {
					a.sum = 0;
					a.dfs(i);
					if (a.sum != 0) {
						pw.println("IMPOSSIBLE");
					}
				}
			}
			pw.println("POSSIBLE");
		}
		pw.close();
	}

	void addEdge(int x, int y) {
		E.get(x).add(y);
		E.get(y).add(x);
	}
	
	void dfs(int x) {
		vis[x] = 1;
		sum += w[x];
		for (int i : E.get(x)) {
			if (vis[i] != 1) {
				dfs(i);
			}
		}
	}

	static void sort(int[] a) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i : a)
			al.add(i);
		Collections.sort(al);
		for (int i = 0; i < a.length; i++)
			a[i] = al.get(i);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
