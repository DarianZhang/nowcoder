package com.cn.nowcoder1.tooffer;

/**
 * @author �Ž�ΰ
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class MinNumberInRotateArray {

	public int minNumberInRotateArray(int [] array) {
	    
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= 0) {
				return 0;
			}
		}
		int i = array.length - 1;
		int minNumber = 0;
		do {
			if (array [i] < array [i-1]) {
				minNumber = array[i];
				break;
			}
			i -- ;
		} while (i >= 0);
		return minNumber;
    }
	
	public static void main(String[] args) {
		MinNumberInRotateArray mira = new MinNumberInRotateArray();
		
		int[] rotateArray = {100,152,165,185,13,48,53,69,95,98};
		System.out.println(mira.minNumberInRotateArray(rotateArray));
	}
}
