package com.cn.nowcoder1.tooffer;

import java.util.Arrays;

/**
 * @author �Ž�ΰ
 * ʱ��Ч��
 * Title:�����г��ִ�������һ�������
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
 * ��������������0��
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
