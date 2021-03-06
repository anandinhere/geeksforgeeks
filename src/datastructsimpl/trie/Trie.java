package datastructsimpl.trie;

/*
 m: average word length

 w : number of words in the trie. 

 Then the boundary O(w*m) is much more useful, 
 since it simply represents the max amount of characters in the trie, 
 which is obviously also it's space boundary.

 Using Trie, we can search the key in O(m) time.
 */
public class Trie {

	static TrieNode root;

	public Trie() {
		// TODO Auto-generated constructor stub
	}

	public static void insert(String key) {

		TrieNode temp = root;
		if (root == null) {
			root = new TrieNode();
			temp = root;
		}

		if (key == null || key.length() == 0) {
			return;
		}

		/*
		 * int index = 0; if (temp.children[key.charAt(index)] == null) {
		 * temp.children[key.charAt(index)] = new TrieNode(); } temp =
		 * temp.children[key.charAt(index)];
		 * 
		 * if (index == key.length() - 1) { temp.leaf = true; temp.count++;
		 * return; }
		 */

		insert(0, key, temp);

	}

	private static void insert(int index, String key, TrieNode root) {

		if (root.children[key.charAt(index)] == null) {
			root.children[key.charAt(index)] = new TrieNode();
		}
		root = root.children[key.charAt(index)];
		if (index == key.length() - 1) {
			root.count++;
			root.leaf = true;
			return;
		}

		insert(index + 1, key, root);

	}

	public static void printKeys(TrieNode root, String s) {

		for (int i = 0; i < root.children.length; i++) {
			if (root.children[i] != null) {
				TrieNode child = root.children[i];
				char c = (char) i;

				if (child.leaf == true) {
					System.out.print(s + c);
					System.out.println(" # " + child.count);
				}
				printKeys(child, s + c);
			}
		}

	}
}
