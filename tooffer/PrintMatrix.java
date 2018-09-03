package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 张建伟
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 
 * 1  2  3  4 
 * 5  6  7  8 
 * 9  10 11 12 
 * 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

	public static ArrayList<Integer> printMatrix(int [][] matrix) {
		
		
		int rowNum = matrix.length;//行
        int colNum=0;
        if(rowNum>0)
            colNum = matrix[0].length;//列
		if (matrix == null||rowNum <= 0||colNum <= 0) {
			return null;
		}
		int start = 0;
		while (rowNum > start*2&& colNum > start*2) {
			printMatrixByCricle(matrix, colNum, rowNum, start);
			start++;
		}
		return m;   
    }
	static ArrayList<Integer> m = new ArrayList<>();
	public static ArrayList<Integer> printMatrixByCricle(int [][] matrix,int colNum, int rowNum, int start) {
		
		int endX = colNum - 1 - start;//y
		int endY = rowNum - 1 - start;//x
		//从左到右打印一行
		for (int i = start; i <= endX; i++) {
			m.add(matrix[start][i]);
		}
		//从上到下打印一列
		if (start<endY) {
			for(int i = start+1; i<= endY ;++i) {
				m.add(matrix[i][endX]);
			}
		}
		//从右到左打印一行
		if (start<endX&&start<endY) {
			for (int i = endX-1; i >= start; i--) {
				m.add(matrix[endY][i]);
			}
		}
		//从下到上打印一列
		if (start<endY-1&&start<endX) {
			for (int i = endY-1; i >= start+1 ; i--) {
				m.add(matrix[i][start]);
			}
		}
		return m;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(printMatrix(matrix));
		int[][] aa = {{1,2,3},{6,5,4}};
		System.out.println(printMatrix(aa));
	}
}
