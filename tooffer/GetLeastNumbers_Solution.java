package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 张建伟
 * 时间效率
 * 最小的k个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {

	private ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        if (k>input.length||k<0) {
			return list;
		}
        if (input == null || input.length == 0) 
        	return list;
		Arrays.sort(input);
		for (int i = 0; i < k; i++) {
			
			list.add(input[i]);
		}
		return list;
    }
	public static void main(String[] args) {
		
		GetLeastNumbers_Solution g = new GetLeastNumbers_Solution();
		
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[] input = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> list2 = g.getLeastNumbers_Solution(input, k);
		for (Integer integer : list2) {
			System.out.print(integer+" ");
		}
	}
}
