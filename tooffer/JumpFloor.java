package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author �Ž�ΰ
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * 1 2 3 5 8 13 21 34
 */
public class JumpFloor {
	
	public int jumpFloor(int target) {
        
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		return jumpFloor(target-2)+jumpFloor(target-1);
    }
	public static void main(String[] args) {
		JumpFloor jFloor = new JumpFloor();
		System.out.println("������̨�ף�");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		System.out.println(jFloor.jumpFloor(target)+"������");
	}
}
