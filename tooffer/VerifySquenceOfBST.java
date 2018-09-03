package com.cn.nowcoder1.tooffer;

/**
 * @author �Ž�ΰ
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No��
 * �������������������������ֶ�������ͬ��
 */
public class VerifySquenceOfBST {

	public boolean verifySquenceOfBST(int [] sequence) {
        
		int length = sequence.length;
		if (sequence == null|| length <= 0) {
			return false;
		}
		return isBST(sequence, 0, length-1);
    }
	public boolean isBST(int [] sequence, int start, int end) {
		
		if(end <= start) return true;
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) 
            	break;
        }
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) 
            	return false;
        }
        return isBST(sequence, start, i-1) && isBST(sequence, i, end-1);
	}
	public static void main(String[] args) {
		
		int[] sequence = {7,4,6,5};
		VerifySquenceOfBST v = new VerifySquenceOfBST();
		System.out.println(v.verifySquenceOfBST(sequence));
	}
}
