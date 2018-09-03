package com.cn.nowcoder1.tooffer;

import java.util.Arrays;

/**
 * @author 张建伟
 * 时间效率
 * Title:数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {

	public int moreThanHalfNum_Solution(int [] array) {
        
		int length = array.length;
		int count = 0;
		
		if (length <= 0) {
			return 0;
		}
		
		Arrays.sort(array);
		int num = array[length/2];
		for (int i = 0; i < length; i++) {
			if (num == array[i]) {
				count ++ ;
			}
		}
		if (count<=(length/2)) {
			num = 0;
		}
		return num;
    }
	
	public static void main(String[] args) {
		
		MoreThanHalfNum_Solution mthns = new MoreThanHalfNum_Solution();
		int [] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(mthns.moreThanHalfNum_Solution(array));
	}
}
