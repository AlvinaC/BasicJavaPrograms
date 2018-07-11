package com.example.programs;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeHeight {
	public static void main(String[] args) {
		BinaryTreeHeight w = new BinaryTreeHeight();
		Node root = new Node(1);
		/*root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);*/

		System.out.println("maxheight :" + w.getMaxHeight(root));
	}

	public int getMaxHeight(Node root) {
		int maxheight = 0;
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			maxheight++;
			while (count-- > 0) {
				Node temp = q.remove();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return maxheight;
	}
}