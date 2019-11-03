package com.example.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DivisorInc {

	class Graph {
		private Map<Integer, Node> nodes = new HashMap<Integer, Node>();

		public Graph() {
		}

		public void addEdge(Integer nodeName1, Integer nodeName2) {
			Node node1 = nodes.get(nodeName1);
			if (node1 == null) {
				node1 = new Node(nodeName1);
			}

			Node node2 = nodes.get(nodeName2);
			if (node2 == null) {
				node2 = new Node(nodeName2);
			}

			node1.addNeighbor(node2);
			node2.addNeighbor(node1);

			nodes.put(nodeName1, node1);
			nodes.put(nodeName2, node2);
		}

		public List<Integer> shortestPath(Integer startNodeName, Integer endNodeName) {
			// key node, value parent
			Map<Integer, Integer> parents = new HashMap<Integer, Integer>();
			List<Node> temp = new ArrayList<Node>();

			Node start = nodes.get(startNodeName);
			temp.add(start);
			parents.put(startNodeName, null);

			while (temp.size() > 0) {
				Node currentNode = temp.get(0);
				List<Node> neighbors = currentNode.getNeighbors();

				for (int i = 0; i < neighbors.size(); i++) {
					Node neighbor = neighbors.get(i);
					Integer nodeName = neighbor.getName();

					// a node can only be visited once if it has more than one parents
					boolean visited = parents.containsKey(nodeName);
					if (visited) {
						continue;
					} else {
						temp.add(neighbor);

						// parents map can be used to get the path
						parents.put(nodeName, currentNode.getName());

						// return the shortest path if end node is reached
						if (nodeName.equals(endNodeName)) {
							System.out.println(parents);
							return getPath(parents, endNodeName);
						}
					}
				}

				temp.remove(0);
			}

			return null;
		}

		private List<Integer> getPath(Map<Integer, Integer> parents, Integer endNodeName) {
			List<Integer> path = new ArrayList<Integer>();
			Integer node = endNodeName;
			while (node != null) {
				path.add(0, node);
				Integer parent = parents.get(node);
				node = parent;
			}
			return path;
		}
	}

	class Node {
		Integer no;
		List<Node> neighbors = new ArrayList<Node>();

		public Node(Integer no) {
			this.no = no;
		}

		public void addNeighbor(Node neighbor) {
			neighbors.add(neighbor);
		}

		public List<Node> getNeighbors() {
			return neighbors;
		}

		public Integer getName() {
			return this.no;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(reader.readLine().trim());
			int m = Integer.parseInt(reader.readLine().trim());
			countOperations(n, m);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int countOperations(int n, int m) {
		if (n == m)
			// System.out.println(0);
			return -1;
		else {
			Graph g = new DivisorInc().new Graph();
			for (int j = n; j < m; j++) {
				for (int i = 2; i <= Math.sqrt(j); i++) {
					if (j % i == 0) {
						// If divisors are equal, print only one
						if (j / i == i) {
							int temp = j + i;
							// System.out.println(i);
							g.addEdge(j, temp);
						} else // Otherwise print both
						{
							int temp = j + i;
							// System.out.println(i + " " + j / i);
							g.addEdge(j, temp);
							temp = j + j / i;
							g.addEdge(j, temp);
						}
					}
				}
			}
			List<Integer> val = g.shortestPath(n, m);
			if (val == null)
				return -1;
			else
				return val.size() - 1;
		}

	}

}
