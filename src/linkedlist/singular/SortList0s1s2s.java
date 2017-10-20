package linkedlist.singular;

import util.linkedlist.LinkList;
import util.linkedlist.LinkedListNode;

public class SortList0s1s2s {

	public static void main(String[] args) {

		LinkList list = new LinkList();

		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(1));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(1));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(2));
		list.addNode(new LinkedListNode(0));
		list.addNode(new LinkedListNode(1));

		list.getHead().printLinkedList();

		sort0s1s2s(list.getHead());

		list.getHead().printLinkedList();
	}

	private static void sort0s1s2s(LinkedListNode head) {
		int zeros = 0, ones = 0, twos = 0;

		LinkedListNode headCopy = head;
		while (headCopy != null) {
			if (headCopy.getValue() == 0) {
				zeros++;
			} else if (headCopy.getValue() == 1) {
				ones++;
			} else {
				twos++;

			}
			headCopy = headCopy.getNext();
		}

		headCopy = head;

		for (int i = 0; i < zeros; i++) {
			headCopy.setValue(0);
			headCopy = headCopy.getNext();
		}
		for (int i = 0; i < ones; i++) {
			headCopy.setValue(1);
			headCopy = headCopy.getNext();
		}
		for (int i = 0; i < twos; i++) {
			headCopy.setValue(2);
			headCopy = headCopy.getNext();
		}

	}
}
