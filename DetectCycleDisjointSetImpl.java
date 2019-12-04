# Detect Cycle in Graph Disjoint Sets based implementation... Path Compression not used here.....

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Detect Cycle in Undirected Graph using Disjoint Sets....
public class DetectCycle {

	int n;
	int[] parent;
	List<Edge> edgeList;

	static class Edge {
		int src;
		int dest;

		Edge(int u, int v) {
			src = u;
			dest = v;
		}
	}

	public DetectCycle(int V) {
		n = V;
		parent = new int[n];
		Arrays.fill(parent,-1);
		edgeList = new LinkedList<>();
	}

	public static void main(String[] args) {
		int V = 4;
		DetectCycle graph = new DetectCycle(V);
		graph.edgeList.add(new Edge(1, 0));
		graph.edgeList.add(new Edge(1, 2));
		graph.edgeList.add(new Edge(0, 3));

		if (graph.containsCycle(graph.edgeList)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	private boolean containsCycle(List<Edge> edgeList) {		
		for(Edge e : edgeList){
			int x = find_set(e.src);
			int y = find_set(e.dest);
			if(x==y)return true;
			parent[x]=y;
		}		
		return false;
	}

	private int find_set(int src) {
		if(parent[src]==-1)return src;
		return find_set(parent[src]);
	}
}
