package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * 本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (n > 0) {
            return handle1(x, n);
        } else {
            return handle2(x, n);
        }
    }

    //n为正数
    private double handle1(double x, int n) {
        if (n == 1) {
            return x;
        }

        int mid = n / 2;
        double p = handle1(x, mid);
        if (n % 2 == 0) {
            return p * p;
        } else {
            return p * p * x;
        }

    }

    //n为负数
    private double handle2(double x, int n) {
        if (n == -1) {
            return 1 / x;
        }

        int mid = n / 2;
        double p = handle2(x, mid);
        if (n % 2 == 0) {
            return p * p;
        } else {
            return p * p * (1 / x);
        }
    }

}
