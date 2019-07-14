package com.gient.linkedlist;

public class MergeApp {

	public static void main(String[] args) {
		SingleLikedList fromList = new SingleLikedList();
		SingleLikedList toList = new SingleLikedList();
		fromList.addByOrder(4, "Å·ÎÄ");
		fromList.addByOrder(1, "Õ²Ä·Ë¹");
		fromList.addByOrder(7, "´÷Î¬Ë¹");
		toList.addByOrder(9, "¶ÅÀ¼ÌØ");
		toList.addByOrder(2, "Î¤µÂ");
		toList.addByOrder(5, "²¨Ê²");
		
		SingleLikedList mergeList = LinkedListUtil.mergeByOrder(fromList, toList);
		mergeList.list();
		
	}
	
}
