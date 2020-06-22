package com.leo.algorithm.work;

public class PrintNumbers {

    public static void main(String[] args) {
        PrintNumbers p = new PrintNumbers();
        p.printNumbers(2);
    }

    public int[] printNumbers(int n) {
        int sum = 0;
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            temp *= 10;
            sum = temp + 9;
            temp = sum;
        }
        int[] res = new int[sum];
        for (int i = 1; i <= res.length; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
