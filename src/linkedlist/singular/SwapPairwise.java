package linkedlist.singular;

import util.linkedlist.ListNode;


//Key is to swap values instead of nodes

public class SwapPairwise {

	public static void main(String[] args) {
		ListNode head = new ListNode().getLinkedList(9);

		head.printLinkedList();

		pairwiseswaploop(head);

		head.printLinkedList();

		pairwiseswaprecursive(head);

		head.printLinkedList();

	}

	private static void pairwiseswaprecursive(ListNode head) {

		if (head == null || head.getNext() == null)
			return;
		int temp = head.getNext().getValue();

		head.getNext().setValue(head.getValue());
		head.setValue(temp);

		pairwiseswaprecursive(head.getNext().getNext());

	}

	private static void pairwiseswaploop(ListNode head) {

		while (head != null && head.getNext() != null) {

			int temp = head.getNext().getValue();

			head.getNext().setValue(head.getValue());
			head.setValue(temp);

			head = head.getNext().getNext();

		}

	}
}
