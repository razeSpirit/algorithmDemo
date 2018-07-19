package org.lhn.binary.search.tree;

/**
 * description:二分查找法
 *
 * @author:LiHaiNan
 * @date:2018/7/18 0018 下午 7:07
 */
public class BinarySearch {
    /**
     * 对于有序数列，才能使用二分查找法（排序的作用）
     * 时间复杂度为log(n)
     * 问题：
     * 1.二分查找法，在有序数组arr中，查找target
     * 2.如果找到target，返回相应的索引index
     * 3.如果没有找到target，返回-1
     */
    /**
     * 非递归的二分查找算法
     *
     * @param arr    只要是实现了Comparable接口的都可以作为参数
     *               传入进去，并且可以调用比较方法
     * @param target 目标值
     * @return
     */
    public static int findByBinarySearch(Comparable[] arr, Comparable target) {
        //1.定义数组的左(l)右(r)下标
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            //2.找到中心点
            //相加的方法在极端情况下可能会导致整形溢出
            //  int mid=(l+r)/2;
            int mid = (r - l) / 2 + l;
            //3.判断目标值与中心点值的大小
            if (arr[mid].compareTo(target) == 0) {
                //相等直接返回下标
                return mid;
            } else if (arr[mid].compareTo(target) == 1) {
                //中间值比target大,需要缩小右端边界范围到mid
                r = mid - 1;
            } else if (arr[mid].compareTo(target) == -1) {
                //中间值比target小,需要增加最左端边界到mid
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归的二分查找算法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchRecursion(Comparable[] arr, Comparable target) {
        //定义左右区间长度
        int l = 0;
        int r = arr.length - 1;
        return binarySearchRecursion(arr, target, l, r);
    }

    public static int binarySearchRecursion(Comparable[] arr, Comparable target, int l, int r) {
        //1.首先判断是否结束
        if (l > r) {
            return -1;
        }
        int mid = (r - l) / 2 + l;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (arr[mid].compareTo(target) == 1) {
            r = mid - 1;
            return binarySearchRecursion(arr, target, l, r);
        } else {
            l = mid + 1;
            return binarySearchRecursion(arr, target, l, r);
        }
    }

    public static void main(String[] args) {
        //定义一个有序数组
        int n = 10000000;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer(i);
        }
        //while循环查询
        long start=System.currentTimeMillis();
        for (int i=0;i<n;i++){
            findByBinarySearch(arr,new Integer(i));
        }
        long end=System.currentTimeMillis();
        System.out.println("while循环二分查找耗时："+(end-start));
        //函数递归查询
        long startRecursion=System.currentTimeMillis();
        for (int i=0;i<n;i++){
            binarySearchRecursion(arr,new Integer(i));
        }
        long endRecursion=System.currentTimeMillis();
        System.out.println("递归循环二分查找耗时："+(endRecursion-startRecursion));
    }
}
