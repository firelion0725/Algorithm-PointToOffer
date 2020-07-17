package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxValue {

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid[0].length; i++) {
            for (int j = 1; j < grid.length; j++) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]) + grid[j][i];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
