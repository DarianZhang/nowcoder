package com.cn.nowcoder1.tooffer;

import java.util.Scanner;

/**
 * @author �Ž�ΰ
 * ������1���ֵĴ�������1��n������1���ֵĴ�����
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
 * Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
 */
public class NumberOf1Between1AndN_Solution {

	public static int numberOf1Between1AndN_Solution(int n) {
        
		int count = 0;//1�ĸ���
        int i = 1;//��ǰλ
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){           
            current = (n/i)%10; //��ǰλ����
            before = n/(i*10); //��λ����
            after = n-(n/i)*i; //��λ����
            //���Ϊ0,����1�Ĵ����ɸ�λ����,���ڸ�λ���� * ��ǰλ��
            if (current == 0)
                count += before*i;
            //���Ϊ1,����1�Ĵ����ɸ�λ�͵�λ����,��λ*��ǰλ+��λ+1
            else if(current == 1)
                count += before * i + after + 1;
            //�������1,����1�Ĵ����ɸ�λ����,//����λ����+1��* ��ǰλ��
            else{
                count += (before + 1) * i;
            }    
            //ǰ��һλ
            i = i*10;
        }
        return count;
    }
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int sum = numberOf1Between1AndN_Solution(n);
		
		System.out.println(sum);
	}	
}
