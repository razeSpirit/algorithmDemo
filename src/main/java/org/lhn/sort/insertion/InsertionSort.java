package org.lhn.sort.insertion;

import org.lhn.util.SortTestTools;

/**
 * @author LiHaiNan
 * @version V1.0
 * @Description: 插入排序算法O(n^2) 级别的
 * @date 上午 10:50 2017/10/16 0016
 */
public class InsertionSort {

    /*理论上说：插入排序比选择排序效率要高，因为插入排序可以提前结束循环查找,但真的是如此吗？
     *其实并不是，因为在比较的同时，他还在不停地执行SortTestTools.swap(arr,j,j-1);交换，交换要比比较更加耗时。
     *改进版，使其在内层循环中只交换一次
    * */

    public static void main(String[] args) {
        System.out.println("**程序开始排序**");
        int n = 1000;
        int[] arr = SortTestTools.randomArrayForInt(n, 100, n);
        long startTime = System.currentTimeMillis();
        insertionSort(arr, n);
        long endTime = System.currentTimeMillis();
        SortTestTools.printArray(arr);
        System.out.println("算法耗时：【" + (endTime - startTime) + "】毫秒");
    }

    //插入排序
    /*
    * 看当前位置的数比它前一个位置的数小，如果小就与前面的数交换位置，
    *以此类推
    */

    /**
     * @Title: insertionSort
     * @Description: 插入排序
     * @Date:上午 10:48 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] arr, int n
     * @return: void
     */
    public static void insertionSort(int[] arr, int n) {
        //对于插入排序来说，数组的第一个位置的数默认是有序的
        for (int i = 1; i < n; i++) {
            //寻找元素arr[i]合适的插入位置,这里使用j>0而不是j>=0是因为每一次都是把
            //当前位置的元素和前一个位置的元素进行交换，所以最后发生的位置是j=1的时候
            for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--) {
                //考察的是当前元素是否比前一个元素的值要小，yes交换位置
                SortTestTools.swap(arr, j, j - 1);
            }
        }
    }

    //插入排序在数据有序性越强的情况下，效率越高，它会趋向于O（n）

    /**
     * @Title: insertionSortPro
     * @Description: 插入排序升级版
     * @Date:上午 10:48 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] arr, int n
     * @return: void
     */
    public static void insertionSortPro(int[] arr, int n) {
        //使其在内层循环只交换一次
        for (int i = 1; i < n; i++) {
            //先把要考察的当前元素由e来保存一个副本
            int e = arr[i];
            int j;//j保存元素应该插入的位置
            //如果arr[j - 1] > e说明不是我们要找的最终位置
            for (j = i; j > 0 && e < arr[j - 1]; j--) {
                //向后移位
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {



    }
}
