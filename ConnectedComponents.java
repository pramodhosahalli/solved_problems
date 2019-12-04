# This code counts number of connected components in a graph

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConnectedComponents {

	int n;
	int parent[];

	List<Edge> arr = null;

	static class Edge {
		int src;
		int dest;

		Edge(int u, int v) {
			src = u;
			dest = v;
		}
	}

	ConnectedComponents(int v) {
		n = v;
		arr = new LinkedList<>();
		parent = new int[n];
		Arrays.fill(parent, -1);
	}

	private void connectComponents() {
		for (Edge e : arr) {
			int x = find_set(e.src);
			int y = find_set(e.dest);

			if (x != y) {
				if (x < y) {
					parent[y] = x;
				} else
					parent[x] = y;
			}
		}
		int count = 0;
		for (int x : parent) {
			if (x == -1)
				count++;
		}
		System.out.println(count);
	}

	private int find_set(int src) {
		if (parent[src] == -1)
			return src;
		return find_set(parent[src]);
	}

	public static void main(String[] args) {
		int n = 10;
		ConnectedComponents cc = new ConnectedComponents(n);
		cc.arr.add(new Edge(0, 1));
		cc.arr.add(new Edge(0, 2));
		cc.arr.add(new Edge(1, 2));
		cc.arr.add(new Edge(1, 3));

		cc.arr.add(new Edge(4, 5));
		cc.arr.add(new Edge(4, 6));
		cc.arr.add(new Edge(7, 8));
		cc.connectComponents();
	}

}
