package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author 张建伟 
 * 变态跳台阶 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。 求该青蛙跳上一个n级的台阶总共有多少种跳法。
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
		System.out.println("跳几个台阶：");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		System.out.println(jFloor.jumpFloorII(target)+"种跳法");
	}
}
