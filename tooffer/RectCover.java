package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author 张建伟
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class RectCover {

	public int rectCover(int target) {
        
		if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        else if(target==2){
            return 2;
        }else{
            return rectCover(target-1)+rectCover(target-2);
        }
    }
	public static void main(String[] args) {
		
		RectCover fs = new RectCover();
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入一个整数n");
		int i = scanner.nextInt();
		System.out.println(fs.rectCover(i));
	}
}
