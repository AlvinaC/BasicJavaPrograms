package com.example.programs;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeWidth {
	public static void main(String[] args) {
		BinaryTreeWidth w = new BinaryTreeWidth();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("maxwidth :" + w.getMaxWidth(root));
	}

	public int getMaxWidth(Node root) {
		int maxwidth = 0;
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			maxwidth = Math.max(maxwidth, count);
			while (count-- > 0) {
				Node temp = q.remove();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return maxwidth;
	}
}