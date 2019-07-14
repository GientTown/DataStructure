package com.gient.linkedlist;

import com.gient.linkedlist.SingleLikedList.Node;

public class App {

	public static void main(String[] args) {
		SingleLikedList list = new SingleLikedList();
		
		list.add(3, "ղķ˹");
		// list.add(3, "ղķ˹");
		list.add(4, "Τ��");
		list.add(5, "��ʲ");
		list.addByOrder(2, "ŷ��");
		list.addByOrder(1, "ŷ��");
		list.update(1, "ղķ˹");
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
