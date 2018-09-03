package com.cn.nowcoder1.tooffer;

/**
 * @author 张建伟
 * 发散性思维
 * 不用加减乘除做加法
 */
public class AddNoyunsuanfu {

	public static int add(int m,int n) {
		
		int sum,carry;
		do {
			sum = m^n;
			carry = (m&n) << 1;
			
			m = sum;
			n = carry;
		} while (n!=0);
		return m;
	}
	
	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		int add = add(m, n);
		System.out.println(add);
	}
}
