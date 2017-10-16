package org.lhn.util;

import java.util.Random;

/**
 * Created With IntelliJ IDEA
 * User: LiHaiNan
 * Date: 2016/12/26 0026
 * Time: 下午 5:23
 * ProjectName: sort
 * 生成排序数据集
 */
public class SortTestTools {

    // 生成有n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
    public static int[] randomArrayForInt(int n,int rangeL,int rangeR){
        int[] arr= new int[n];
        Random random=new Random();
        for (int i=0;i<n;i++){
            /*
            * random.nextInt(max)表示生成[0,max]之间的随机数，然后对(max-min+1)取模。
            * 以生成[10,20]随机数为例，首先生成0-20的随机数，然后对(20-10+1)取模得到
            * [0-10]之间的随机数，然后加上min=10，最后生成的是10-20的随机数
            * */
            arr[i]= random.nextInt(rangeR)%(rangeR-rangeL+1)+rangeL ;
        }
        return arr;
    }


    //打印arr数组的所有内容
    public static  void printArray(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //位置交换
    //将下标为i的与下标为j的进行位置交换
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
