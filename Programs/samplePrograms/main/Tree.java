package main;

public class Tree {
	Node root;

	// Tree Node
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Function to insert nodes in level order
	public Node insertLevelOrder(int[] arr, Node root, int i) {
		// Base case for recursion
		if (i < arr.length) {
			Node temp = new Node(arr[i]);
			root = temp;

			// insert left child
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	// Function to print tree nodes in InOrder fashion
	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	// Driver program to test above function
	public static void main(String args[]) {
		Tree tree = new Tree();
		int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		System.out.println("in order");
		tree.inOrder(tree.root);
		System.out.println("\n" + "preOrder");
		tree.preOrder(tree.root);
		System.out.println("\n" + "postOrder");
		tree.postOrder(tree.root);
	}
}