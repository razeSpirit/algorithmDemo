package org.lhn.util;

/**
 * @author LiHaiNan
 * @version V1.0
 * @Description: 递归算法
 * @date 下午 4:07 2017/10/18 0018
 */
public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(plus(5));
        System.out.println(multiplication(5));
    }

    /**
     * @Title: plus
     * @Description: 求1到n的和
     * @Date:下午 4:08 2017/10/18 0018
     * @author LiHaiNan
     * @param: int n 要求和的数
     * @return: int
     */
    public static int plus(int n) {
        if (n == 1) {
            return n;
        }
        int total = plus(n - 1) + n;
        return total;
    }

    /**
     * @Title: plus
     * @Description: 递归求阶乘
     * @Date:下午 4:08 2017/10/18 0018
     * @author LiHaiNan
     * @param: int n 要求阶乘的数
     * @return: int
     */
    public static int multiplication(int n) {
        if (1 == n) {
            return n;
        }
        int total = n * multiplication(n - 1);
        return total;
    }

}
