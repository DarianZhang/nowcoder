package com.cn.nowcoder1.tooffer;

import java.util.Stack;

/**
 * @author �Ž�ΰ
 *	����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class NumberOf1 {
	public int numberOf1(int n) {
		int t=0;
        char[]ch=Integer.toBinaryString(n).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'){
                t++;
            }
        }
        return t;
    }

	public int numberOf2(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	public static void main(String[] args) {
		NumberOf1 no1 = new NumberOf1();
		System.out.println("���������Ʊ�ʾ��1�ĸ���:"+no1.numberOf1(129));
		System.out.println("���������Ʊ�ʾ��1�ĸ���:"+no1.numberOf2(129));
	}
}
