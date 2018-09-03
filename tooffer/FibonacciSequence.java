package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author 张建伟
 * 斐波那契数列：1 1 2 3 5 8 13 21 34 55 89 144
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FibonacciSequence {

	public int Fibonacci(int n) {
        if (n==0) {
			return 0;
		}
        if (n==1) {
			return 1;
		}
        return Fibonacci(n-2)+Fibonacci(n-1);
    }
	public static void main(String[] args) {
		
		FibonacciSequence fs = new FibonacciSequence();
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入一个整数n,n<=39:");
		int i = scanner.nextInt();
		System.out.println(fs.Fibonacci(i));
	}
}
