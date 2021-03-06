package linkedlist.singular;

import java.util.LinkedList;

import util.linkedlist.LinkList;
import util.linkedlist.ListNode;

public class IntersectionOfLinkedLists {
	public static void main(String[] args) {

		ListNode listHeadA = new ListNode().getLinkedList(0);

		ListNode listHeadB = new ListNode().getLinkedList(4);

		ListNode copyB = listHeadB;

		while (copyB.getNext() != null)
			copyB = copyB.getNext();

		copyB.setNext(listHeadA);

		System.out.println("listA");
		listHeadA.printLinkedList();
		System.out.println("listB");
		listHeadB.printLinkedList();

		copyB = listHeadB;
		ListNode copyA = listHeadA;

		int sizeA = 0;
		int sizeB = 0;

		while (copyB != null) {
			copyB = copyB.getNext();
			sizeB++;
		}

		while (copyA != null) {
			copyA = copyA.getNext();
			sizeA++;
		}

		copyB = listHeadB;
		copyA = listHeadA;

		if (sizeA > sizeB) {

			for (int i = 0; i < sizeA - sizeB; i++) {
				copyA = copyA.getNext();
			}
			while (copyB != copyA) {
				copyB = copyB.getNext();
				copyA = copyA.getNext();
			}

		} else {
			for (int i = 0; i < sizeB - sizeA; i++) {
				copyB = copyB.getNext();
			}
			while (copyB != copyA) {
				copyB = copyB.getNext();
				copyA = copyA.getNext();
			}

		}

		System.out.println("Intersection is at " + copyB.getValue());

	}
}
