package com.gient.sparsearray;

import java.util.Arrays;

/**
 * @author gient
 * @date 2019-07-13
 * @description: ϡ����������ͨ��ά�����ת��
 */
public class SparseArray {

	
	/**
	 * �Ӷ�λ����תϡ������
	 * 
	 * ʾ��
	 * 0 0 0 0 1
	 * 1 0 0 0 0
	 * 0 0 0 2 0
	 * 0 0 0 0 0
	 * 
	 * ��0����ľ�Ϊ��Ч����
	 * 
	 * @param array ��ά����
	 * @return ϡ������
	 */
	public static int[][] transferFrom(int[][] array) {
		// �ݲ������ж�
		
		// ��ȡ�����к���
		int row = array.length;
		int column = array[0].length;
		
		// ��Ҫ������ά�������Ч���ݣ�����ȷ��ϡ���������ֵ
		int[][] sparseArray = new int[4][3];
		
		// ϡ��������кţ���Ϊ��0�д洢��ά�����������Ϣ
		int sRow = 1;
		
		// array��Ч���ݵ�����
		int sum = 0;
		
		// ����array
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != 0) {
					sparseArray[sRow][0] = i;
					sparseArray[sRow][1] = j;
					sparseArray[sRow][2] = array[i][j];
					
					sRow++;
					sum++;
				}
			}
		}
		
		sparseArray[0][0] = row;
		sparseArray[0][1] = column;
		sparseArray[0][2] = sum;
		
		return sparseArray;
	}
	
	/**
	 * ��ϡ������ת��ά����
	 * @param array ϡ������
	 * @return ��ά����
	 */
	public static int[][] transferTo(int[][] sparseArray) {
		
		// ��ȡϡ������ĵ�0�����ݣ�����ά�����������Ϣ
		int aRow = sparseArray[0][0];
		int aColumn = sparseArray[0][1];
		
		int[][] array = new int[aRow][aColumn];
		
		for (int i = 1; i < sparseArray.length; i++) {
			int row = sparseArray[i][0];
			int colomn = sparseArray[i][1];
			int value = sparseArray[i][2];
			array[row][colomn] = value;
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		/* 0 0 0 0 1
		 1 0 0 0 0
		 0 0 0 2 0
		 0 0 0 0 0*/
		int[][] originArray = {
							{0, 0, 0, 0, 1},
							{1, 0, 0, 0, 0},
							{0, 0, 0, 2, 0},
							{0, 0, 0, 0, 0}
						};
		int[][] sparseArray = SparseArray.transferFrom(originArray);
		
		System.out.println("Array-->sparseArray");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.println(Arrays.toString(sparseArray[i]));
		}
		
		int[][] array = SparseArray.transferTo(sparseArray);
		
		System.out.println("sparseArray-->Array");
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}
	
}
