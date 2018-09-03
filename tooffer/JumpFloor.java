package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author 张建伟
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
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
		System.out.println("跳几个台阶：");
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		System.out.println(jFloor.jumpFloor(target)+"种跳法");
	}
}
