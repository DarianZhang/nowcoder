package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author �Ž�ΰ
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
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
		System.out.print("����һ������n");
		int i = scanner.nextInt();
		System.out.println(fs.rectCover(i));
	}
}
