package com.gient.linkedlist;

public class MergeApp {

	public static void main(String[] args) {
		SingleLikedList fromList = new SingleLikedList();
		SingleLikedList toList = new SingleLikedList();
		fromList.addByOrder(4, "ŷ��");
		fromList.addByOrder(1, "ղķ˹");
		fromList.addByOrder(7, "��ά˹");
		toList.addByOrder(9, "������");
		toList.addByOrder(2, "Τ��");
		toList.addByOrder(5, "��ʲ");
		
		SingleLikedList mergeList = LinkedListUtil.mergeByOrder(fromList, toList);
		mergeList.list();
		
	}
	
}
