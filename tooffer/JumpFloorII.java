package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author �Ž�ΰ 
 * ��̬��̨�� 
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���� �����������һ��n����̨���ܹ��ж�����������
 */
public class JumpFloorII {

	public int jumpFloorII(int target) {

		/*2^(target-1)*/
		if (target == 1)
            return 1;
        return 2 * jumpFloorII(target - 1);
	}
	public static void main(String[] args) {
		JumpFloorII jFloor = new JumpFloorII();
		System.out.println("������̨�ף�");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		System.out.println(jFloor.jumpFloorII(target)+"������");
	}
}
