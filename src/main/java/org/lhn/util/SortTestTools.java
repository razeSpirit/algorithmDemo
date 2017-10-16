package org.lhn.util;

import java.util.Random;

/**
 * @author LiHaiNan
 * @version V1.0
 * @Description: 生成排序数据集
 * @date 上午 10:50 2017/10/16 0016
 */
public class SortTestTools {

    /**
     * @Title: randomArrayForInt
     * @Description: 生成有n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
     * @Date:上午 10:46 2017/10/16 0016
     * @author LiHaiNan
     * @param: int n,int rangeL,int rangeR
     * @return: int[]
     */
    public static int[] randomArrayForInt(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            /*
            * random.nextInt(max)表示生成[0,max]之间的随机数，然后对(max-min+1)取模。
            * 以生成[10,20]随机数为例，首先生成0-20的随机数，然后对(20-10+1)取模得到
            * [0-10]之间的随机数，然后加上min=10，最后生成的是10-20的随机数
            * */
            arr[i] = random.nextInt(rangeR) % (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }


    /**
     * @Title: printArray
     * @Description: 打印arr数组的所有内容
     * @Date:上午 10:46 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] arr
     * @return: void
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * @Title: swap
     * @Description: 位置交换, 将下标为i的与下标为j的进行位置交换
     * @Date:上午 10:45 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] a, int i, int j
     * @return: void
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
