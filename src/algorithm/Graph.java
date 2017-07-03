package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
	// map node id to actual node, this is going to be used for get node and add
	// edge
	// get immediate access to the node of the particular id
	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static void main(String[] args) {

	}

	public static class Node {
		private int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();

		private Node(int id) {
			this.id = id;
		}
	}

	private Node getNode(int id) {
		return nodeLookup.get(id);
	}

	public void addEdge(int source, int destination) {

	}

	public boolean hasPathDSF(Node source, Node destination) {
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDSF(source, destination, visited);
	}

	private boolean hasPathDSF(Node source, Node destination, HashSet<Integer> visited) {
		if (visited.contains(source.id))
			return false;
		visited.add(source.id);
		if (source.id == destination.id)
			return true;
		else {
			for (Node child : source.adjacent) {
				if (hasPathDSF(child, destination, visited))
					return true;
			}
		}
		return false;

	}

	public boolean hasPathBFS(int s, int d) {
		return hasPathBFS(getNode(s), getNode(d));
	}

	private boolean hasPathBFS(Node source, Node destination) {
		// Nodes visisted next
		LinkedList<Node> nextToVisit = new LinkedList<Node>();

		HashSet<Integer> visited = new HashSet<Integer>();
		// next visit is my source
		nextToVisit.add(source);
		while (!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if (node.id == destination.id) {
				return true;
			}
			if (visited.contains(source.id))
				continue;
			visited.add(source.id);
			// queue all my children to the end of the queue
			nextToVisit.addAll(source.adjacent);
		}
		// get down to the very end and I have not found my destination after
		// all of this,
		return false;

	}
}
