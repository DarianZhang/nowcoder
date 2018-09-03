package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author 张建伟
 * 发散性思维
 * 1+2+...+n
 */
public class SumFormOneToN {

	public static int sum(int n) {
		
		return n*(n+1)>>1;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int sum = sum(n);
		
		System.out.println(sum);
	}
}
