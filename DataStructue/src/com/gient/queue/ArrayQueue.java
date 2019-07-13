package com.gient.queue;

/**
 * @author gient
 * @date 2019-07-13
 * @description:ʹ������ʵ�ֶ��У����ַ�ʽ�����鲻���ظ�ʹ�ã�
 */
public class ArrayQueue {

	private static int DEFAULT_MAX_SIZE = 10;
	
	// ���ڴ������
	int[] array;
	
	// ���е��������
	private int maxSize;
	// ����λ��
	private int front = -1;
	// ��βλ��
	private int rear = -1;
	
	public ArrayQueue() {
		this(DEFAULT_MAX_SIZE);
	}
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	
	/**
	 * ��������������
	 * @param value
	 * @return
	 */
	public boolean add(int value) {
		boolean flag = false;
		if (isFull()) {
			return flag;
		}
		array[++rear] = value;
		flag = true;
		
		return flag;
	}
	
	/**
	 * �Ӷ����л�ȡ����
	 * @return
	 */
	public int get() {
		int value;
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�");
		}
		
		value = array[++front];
		
		return value;
	}
	
	/**
	 * �ж϶����Ƿ���
	 * @return
	 */
	public boolean isFull() {
		
		return rear == maxSize -1;
	}
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		
		return front == rear;
	}
}
