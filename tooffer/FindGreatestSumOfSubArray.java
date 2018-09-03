package com.cn.nowcoder1.tooffer;


/**
 * @author �Ž�ΰ
 * ʱ��Ч��	
 * ���������������
 * 				HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 */
public class FindGreatestSumOfSubArray {

	public int findGreatestSumOfSubArray(int[] array) {
        
		if (array.length == 0) {
            return 0;
        }
        int flag = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            flag = 0;
            for (int a = i; a < array.length; a++) {
                flag += array[a];
                if ( max < flag) {
                    max = flag;
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		
		FindGreatestSumOfSubArray fgsos = new FindGreatestSumOfSubArray();
		
		int[] array1 = {1,-2,3,10,-4,7,2,-5};
		System.out.println(fgsos.findGreatestSumOfSubArray(array1));
		
		int[] array2 = {6,-3,-2,7,-15,1,2,2};
		System.out.println(fgsos.findGreatestSumOfSubArray(array2));
	}
}
