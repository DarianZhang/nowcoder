package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author �Ž�ΰ
 * 쳲��������У�1 1 2 3 5 8 13 21 34 55 89 144
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
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
		System.out.print("����һ������n,n<=39:");
		int i = scanner.nextInt();
		System.out.println(fs.Fibonacci(i));
	}
}
