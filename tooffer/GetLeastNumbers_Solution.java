package com.cn.nowcoder1.tooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author �Ž�ΰ
 * ʱ��Ч��
 * ��С��k����
 * ����n���������ҳ�������С��K������
 * ��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
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
