import java.util.LinkedList;
import java.util.Stack;

//Implementation of Kosaraju's Algorithm O(V+E)
public class StronglyConnectedComponents {

	int n;
	LinkedList<Integer>[] edgeList = null;
	LinkedList<Integer>[] reverse_edgeList = null;

	Stack<Integer> stack = null;

	@SuppressWarnings("unchecked")
	public StronglyConnectedComponents(int v) {
		n = v;
		edgeList = new LinkedList[n];
		reverse_edgeList = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			edgeList[i] = new LinkedList<Integer>();
			reverse_edgeList[i] = new LinkedList<Integer>();
		}
		stack = new Stack<>();
	}

	private void addEdge(int u, int v) {
		edgeList[u].add(v);
		reverse_edgeList[v].add(u);
	}

	void dfsUtil() {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				dfs(i, visited);
		}
	}

	void dfsUtil2ndPass() {
		boolean[] visited = new boolean[n];
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (!visited[top]) {
				dfs2ndPass(top, visited);
				System.out.println();
			}
		}
	}

	private void dfs2ndPass(int src, boolean[] visited) {
		visited[src] = true;
		for (int x : reverse_edgeList[src]) {
			if (!visited[x])
				dfs2ndPass(x, visited);
		}
		System.out.print(src);
	}

	void dfs(int src, boolean[] visited) {
		visited[src] = true;
		for (int x : edgeList[src]) {
			if (!visited[x])
				dfs(x, visited);
		}
		stack.push(src);
	}

	public static void main(String[] args) {
		int v = 11;
		StronglyConnectedComponents scc = new StronglyConnectedComponents(v);
		scc.addEdge(0, 1);
		scc.addEdge(1, 2);
		scc.addEdge(1, 3);
		scc.addEdge(2, 0);
		scc.addEdge(3, 4);
		scc.addEdge(4, 5);
		scc.addEdge(5, 3);
		scc.addEdge(6, 5);
		scc.addEdge(6, 7);
		scc.addEdge(7, 8);
		scc.addEdge(8, 9);
		scc.addEdge(9, 6);
		scc.addEdge(9, 10);

		scc.dfsUtil();
		scc.dfsUtil2ndPass();
	}

}
