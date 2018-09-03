package com.cn.nowcoder1.tooffer;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class ArrayLookUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		int[][] array = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = (int) (Math.random()*100);
			}
		}
		ArrayLookUp alu = new ArrayLookUp();
		System.out.println("产生的二维数组：");
		alu.sort(array);
		
		System.out.println("请输入一个整数，判断在二维数组中是否存在：");
		int zs = scanner.nextInt();
		
		System.out.println(alu.Find1(zs, array));
		
		System.out.println(alu.Find2(zs, array));
		
		alu.Time(zs, array);
	}
	public void sort(int[][] a){//顺序排序,每一行都按照从左到右递增的顺序排序，
						         //每一列都按照从上到下递增的顺序排序
		for (int i = 0; i < a.length; i++) { 		// 二维数组的长度
			for (int j = 0; j < a[i].length; j++) { // 每个一维数组的长度
				int n = j + 1;
				for (int m = i; m < a.length; m++) {
					for (; n < a[i].length; n++) {
						if (a[i][j] > a[m][n]) {
							int min = a[m][n];
							a[m][n] = a[i][j];
							a[i][j] = min;
						}
					}
					n = 0; // 此处是给n从第二个一维数组开始取0这个坐标
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public boolean Find1(int target, int [][] array) {
		
		int row = 0 ;
		int col = array[0].length-1;
		while (row <= array.length-1 && col >= 0) {
			if (target == array[row][col]) {
				return true;
			} else if (target < array[row][col]) {
				col--;
			} else if (target > array[row][col]) {
				row++;
			}
		}
		return false;

    }

	public boolean Find2(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int low = 0;
			int high = array[i].length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (target > array[i][mid])
					low = mid + 1;
				else if (target < array[i][mid])
					high = mid - 1;
				else
					return true;
			}
		}
		return false;
		
	}
	public void Time(int zs, int[][] array){
		ArrayLookUp alu = new ArrayLookUp();
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			alu.Find1(zs, array);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("one时间:"+(endTime-startTime));
		
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			alu.Find2(zs, array);
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("two时间:"+(endTime2-startTime2));
	}
}
