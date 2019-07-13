package com.gient.sparsearray;

import java.util.Arrays;

/**
 * @author gient
 * @date 2019-07-13
 * @description: 稀疏数组与普通二维数组的转换
 */
public class SparseArray {

	
	/**
	 * 从二位数组转稀疏数组
	 * 
	 * 示例
	 * 0 0 0 0 1
	 * 1 0 0 0 0
	 * 0 0 0 2 0
	 * 0 0 0 0 0
	 * 
	 * 除0以外的均为有效数据
	 * 
	 * @param array 二维数组
	 * @return 稀疏数组
	 */
	public static int[][] transferFrom(int[][] array) {
		// 暂不做空判断
		
		// 获取数组行和列
		int row = array.length;
		int column = array[0].length;
		
		// 需要遍历二维数组的有效数据，才能确定稀疏数组的行值
		int[][] sparseArray = new int[4][3];
		
		// 稀疏数组的行号，因为第0行存储二维数组的行列信息
		int sRow = 1;
		
		// array有效数据的数量
		int sum = 0;
		
		// 遍历array
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
	 * 从稀疏数组转二维数组
	 * @param array 稀疏数组
	 * @return 二维数组
	 */
	public static int[][] transferTo(int[][] sparseArray) {
		
		// 获取稀疏数组的第0行数据，即二维数组的行列信息
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
