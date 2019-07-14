package com.gient.linkedlist;

import java.util.Iterator;
import java.util.Stack;

import com.gient.linkedlist.SingleLikedList.Node;

/**
 * @author gient
 * @date 2019-07-14
 * @description:������������ϰ��
 */
public class LinkedListUtil {

	/**
	 * ���ҵ���������index���ڵ�
	 * @param index
	 * @return
	 */
	public static Node findNodeFromEnd(SingleLikedList list, int index) {
		
		if (list == null) {
			return null;
		}
		
		// ��ȡ������length
		int len = list.length();
		if (index < 0 || (len - index) < 0) {
			return null;
		}
		
		Node temp = list.getHead();
		
		// ������length-size�����������ҽڵ��ǰһ���ڵ�
		for (int i = 0; i < len - index; i++) {
			temp = temp.next;
		}
		return temp.next;
	}
	
	/**
	 * ����������з�ת
	 * @param list
	 * @return
	 */
	public static SingleLikedList reverse(SingleLikedList list) {
		if (list == null) {
			return null;
		}
		SingleLikedList reverseList = new SingleLikedList();
		Node reverseHead = reverseList.getHead();
		
		Node head = list.getHead();
		Node current = head.next;
		Node next = null;
		// ����list
		while(true) {
			if (current == null) {
				break;
			}
			// ���浱ǰ�ڵ���һ���ڵ�
			next = current.next;
			// ���뵽��ת������
			current.next = reverseHead.next;
			reverseHead.next = current;
			current = next;
		}
		return reverseList;
	}
	
	/**
	 * ��β��ͷ��ӡ����������ջʵ��
	 * @param list
	 */
	public static void printFromEnd(SingleLikedList list) {
		if(list == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		
		Node current = list.getHead();
		
		while (current.next != null) {
			stack.push(current.next);
			current = current.next;
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	/**
	 * ��������������ϲ���һ����������
	 * ��fromList�ϲ���toList
	 * @param fromList
	 * @param toList
	 * @return
	 */
	public static SingleLikedList mergeByOrder(SingleLikedList fromList, SingleLikedList toList) {
		if (fromList == null) {
			return toList;
		}
		if (toList == null) {
			return fromList;
		}
		
		// ֱ��ȡ������Ľڵ�
		Node fCurrent = fromList.getHead().next;
		// ȡͷ�ڵ㣬���������Ҫ��ȡ����λ�õ�ǰһ���ڵ�
		Node tCurrent = toList.getHead();
		
		Node fNext = null;
		
		while(fCurrent != null) {
			// ��˳����뵽toList��
			while (true) {
				// �ϲ�
				if (tCurrent.next.getNum() >= fCurrent.getNum()) {
					fNext = fCurrent.next;
					fCurrent.next = tCurrent.next;
					tCurrent.next = fCurrent;
					
					tCurrent = fCurrent;
					fCurrent = fNext;
					break;
				}
				// fromList����
				tCurrent = tCurrent.next;
			}
		}
		return toList;
	}
}
