package com.leo.algorithm.work;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {{2, 3, 8, 11, 15, 19, 20, 20}, {4, 8, 12, 15, 18, 21, 25, 28}, {5, 8, 17, 20, 22, 23, 30, 34}
                , {6, 12, 18, 20, 25, 25, 34, 34}, {9, 14, 21, 24, 25, 29, 39, 40}};
        FindNumberIn2DArray f = new FindNumberIn2DArray();
        f.findNumberIn2DArray(matrix, 12);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        int right = -1;
        int bottom = -1;
        int left = -1;
        int top = -1;
        //右边界
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == target) {
                return true;
            }
            if (matrix[0][i] > target) {
                right = i - 1;
                break;
            }
        }
        if (right == -1) {
            right = matrix[0].length - 1;
        }
        //下边界
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == target) {
                return true;
            }
            if (matrix[i][0] > target) {
                bottom = i - 1;
                break;
            }
        }

        if (bottom == -1) {
            bottom = matrix.length - 1;
        }
        //上边界
        for (int i = 0; i <= bottom; i++) {
            if (matrix[i][right] == target) {
                return true;
            }
            if (matrix[i][right] > target) {
                top = i;
                break;
            }
        }

        if (top == -1) {
            top = 0;
        }
        //左边界
        for (int i = 0; i <= right; i++) {
            if (matrix[bottom][i] == target) {
                return true;
            }
            if (matrix[bottom][i] > target) {
                left = i;
                break;
            }
        }

        if (left == -1) {
            left = 0;
        }

        //范围缩小后遍历 缩小的矩阵

        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                if (matrix[j][i] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    //左下角消去法
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }


}
