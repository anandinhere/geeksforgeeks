package binarytree;

import java.util.Map;
import java.util.Map.Entry;

import datastructsimpl.HashMap;
import util.tree.TreeNode;

public class TreeFromInorderLevelOrder {

	static int preIndex = 0;

	public static void main(String[] args) {
		//int inorder[] = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		//int levelorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		 //int inorder[] = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		// int levelorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		 int inorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		 int levelorder[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		Map<Integer, Integer> m = new java.util.HashMap<Integer, Integer>();
		for (int i = 0; i < levelorder.length; i++) {
			m.put(levelorder[i], i);
		}

		TreeNode root = new TreeNode(levelorder[preIndex++]);
		TreeNode r = makeTree(root, inorder, levelorder, 0, inorder.length - 1,
				m);

		r.printInorder(r);
	}

	private static TreeNode makeTree(TreeNode root, int[] inorder,
			int[] levelorder, int inStart, int inEnd, Map<Integer, Integer> m) {

		if (root == null) {
			return null;
		}

		int inSearch = search(root.key, inorder, inStart, inEnd);

		if (inStart < inSearch) {
			int leftKey = getNode(inorder, levelorder, inStart, inSearch - 1, m);
			root.left = new TreeNode(levelorder[leftKey]);
		}

		if (inSearch > inStart) {
			int rightKey = getNode(inorder, levelorder, inSearch + 1, inEnd, m);
			root.right = new TreeNode(levelorder[rightKey]);
		}

		makeTree(root.left, inorder, levelorder, inStart, inSearch - 1, m);
		makeTree(root.right, inorder, levelorder, inSearch + 1, inEnd, m);

		return root;
	}

	private static int getNode(int[] inorder, int[] levelorder, int inStart,
			int inEnd, Map<Integer, Integer> m) {

		int min = Integer.MAX_VALUE;

		for (int i = inStart; i <= inEnd; i++) {
			if (m.get(inorder[i]) < min)
				min = m.get(inorder[i]);
		}

		return min;
	}

	private static int search(int pStart, int[] inorder, int inStart, int inEnd) {

		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == pStart) {
				return i;
			}
		}
		return 0;
	}

}
