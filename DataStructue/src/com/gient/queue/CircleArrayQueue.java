package com.gient.queue;

/**
 * @author gient
 * @date 2019-07-13
 * @description:ʹ������ʵ�ֻ��ζ���
 */
public class CircleArrayQueue {

private static int DEFAULT_MAX_SIZE = 10;
	
	// ���ڴ������
	int[] array;
	
	// ���е��������
	private int maxSize;
	// ��������������С
	private int size = 0;
	// ����λ�ã�ָ���һ��Ԫ��
	private int front = 0;
	// ��βλ�ã�ָ�����һ��Ԫ��
	private int rear = -1;
	
	public CircleArrayQueue() {
		this(DEFAULT_MAX_SIZE);
	}
	
	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	
	public boolean add(int value) {
		if (isFull()) {
			return false;
		}
		rear = (rear + 1) % maxSize;
		array[rear] = value;
		size++;
		
		return true;
	}
	
	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�");
		}
		int value = array[front];
		front = (front + 1) % maxSize;
		size--;
		return value;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�");
		}
		return array[front];
	}
	
	/**
	 * ��������
	 * @return
	 */
	public int[] list() {
		int count = 0;
		int[] queue = new int[size];
		for (int i = front; i != rear ; i = (i + 1) % maxSize) {
			queue[count++] = array[i];
		}
		queue[count] = array[rear];
		
		return queue;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ������
	 * @return
	 */
	public boolean isFull() {
		return maxSize == size;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
}
