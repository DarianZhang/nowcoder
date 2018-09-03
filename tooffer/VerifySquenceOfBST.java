package com.cn.nowcoder1.tooffer;

/**
 * @author 张建伟
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
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
