package org.lhn.selectionsort;

import org.lhn.util.SortTestTools;

/**
 * Created With IntelliJ IDEA
 * User: LiHaiNan
 * Date: 2016/12/26 0026
 * Time: 下午 5:23
 * 选择排序算法O(n^2) 级别的
 */
public class SelectionSort {

    public static void main(String[] args) {
        System.out.println("**程序开始排序**");
        int n = 1000;
        int[] arr = SortTestTools.randomArrayForInt(n, 100, n);
        long startTime = System.currentTimeMillis();
        selectionSort(arr, n);
        long endTime = System.currentTimeMillis();
        SortTestTools.printArray(arr);
        System.out.println("算法耗时：【" + (endTime - startTime) + "】毫秒");
    }

    //选择排序
    /*
    * 1.在整个数组中找出最小数的位置minIndex
    * 2.将最小数与第一名的位置交换
    * 3.检索之后的最小数的位置并与第二名的位置交换，以此类推实现排序
    * */

    //int arr[]要排序的数组，int n 数组大小
    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            //遍历数组，寻找[i,n)区间里的最小值
            int minIndex = i;
            //注意：是在数组的第二个位置进行检索，并不是从头开始检索,因为minIndex初始化的为第一个
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    //判断当前索引位置的值是否小于最小值
                    minIndex = j;
                }
            }
            //与第一交换位置
            SortTestTools.swap(arr, i, minIndex);
        }
    }


}
