package com.gient.linkedlist;

import com.gient.linkedlist.SingleLikedList.Node;

public class App {

	public static void main(String[] args) {
		SingleLikedList list = new SingleLikedList();
		
		list.add(3, "Õ²Ä·Ë¹");
		// list.add(3, "Õ²Ä·Ë¹");
		list.add(4, "Î¤µÂ");
		list.add(5, "²¨Ê²");
		list.addByOrder(2, "Å·ÎÄ");
		list.addByOrder(1, "Å·ÎÄ");
		list.update(1, "Õ²Ä·Ë¹");
		list.delete(2);
		
		list.list();
		int length = list.length();
		System.out.println(length);
		
		Node node = LinkedListUtil.findNodeFromEnd(list, 4);
		System.out.println(node);
		System.out.println("=====reverseList=====");
		
		SingleLikedList reverseList = LinkedListUtil.reverse(list);
		reverseList.list();
		System.out.println("=====printFromEnd=====");
		LinkedListUtil.printFromEnd(reverseList);
	}
	
}
