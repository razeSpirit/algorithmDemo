package org.lhn.mergesort;

import org.lhn.util.SortTestTools;

/**
 * @author LiHaiNan
 * @version V1.0
 * @Description: 归并排序（注意边界问题）
 * @date 下午 6:29 2017/10/16 0016
 */
public class MergeSort {

    public static void main(String[] args) {
        System.out.println("**程序开始排序**");
//        int[] arr = SortTestTools.randomArrayForInt(n, 0, n);
        int[] arr = {7, 9, 2, 1, 8};
        int n = arr.length;
        SortTestTools.printArray(arr);
        long startTime = System.currentTimeMillis();
        mergeSort(arr, n);
        long endTime = System.currentTimeMillis();
        SortTestTools.printArray(arr);
        System.out.println("算法耗时：【" + (endTime - startTime) + "】毫秒");
    }


    /**
     * @Title: mergeSort
     * @Description: 归并排序
     * @Date:下午 6:37 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] arr数组, int n数组长度
     * @return: void
     */
    private static void mergeSort(int[] arr, int n) {
        myMergeSort(arr, 0, n - 1);
    }

    /**
     * @Title: myMergeSort
     * @Description: 内部调用子函数，递归使用归并排序，对arr[start...end]的范围进行排序
     * end定义：最后一个元素的位置，而不是最后一个元素后一个的位置。
     * @Date:下午 6:30 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] arr要排序的数组,
     * int start要处理数据段的开始位置, int end要处理数据段的结束位置
     * @return: void
     */
    private static void myMergeSort(int[] arr, int left, int right) {
        //1.对于一个递归函数来说，首先需要处理递归到底的情况
        //2.left<right时，则至少存在两个元素，还需要进行二分
        if (left >= right) {
            return;
        }
        //进行归并排序
        //注意：当left，right比较大的时候进行相加可能会发生溢出现象
        int mid = (left + right) / 2;
        //对分开的左右两个部分进行归并排序
        //左部分
        myMergeSort(arr, left, mid);
        //右部分
        myMergeSort(arr, mid + 1, right);
        /*归并完成，进行merge操作*/
        myMerge(arr, left, mid, right);
    }

    /**
     * @Title: myMerge
     * @Description: 将arr[start...mid]和arr[mid+1..end]两部分进行归并
     * @Date:下午 6:48 2017/10/16 0016
     * @author LiHaiNan
     * @param: int[] arr, int start, int mid, int end
     * @return: void
     */
    private static void myMerge(int[] arr, int left, int mid, int right) {
        //创建一个临时数组
        int[] temp = new int[right - left + 1];
        //将目前所有需要处理的数组数据复制到temp类数组中
        for (int i = left; i <= right; i++) {
            //注意：temp数组是从0开始的，而arr数组则是在start开始的
            //所以需要处理下标偏移（i-start）
            temp[i - left] = arr[i];
        }
        //两个下标分别指向两部分的开始位置
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            //判断索引的合法性
            if (i > mid) {
                arr[k] = temp[j - left];
                j++;
            } else if (j > right) {
                arr[k] = temp[i - left];
                i++;
            }
            /*如何上述两个条件都不满足，进而才是有效的*/
            //每一次决定arr[K]的位置应该是谁
            else if (arr[i - left] < arr[j - left]) {
                arr[k] = temp[i - left];
                i++;
            } else {
                arr[k] = temp[j - left];
                j++;
            }
        }
    }
}
