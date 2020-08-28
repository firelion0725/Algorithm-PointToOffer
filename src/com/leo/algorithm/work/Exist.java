package com.leo.algorithm.work;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int raw = board.length;
        int col = board[0].length;
        if (raw == 0 || col == 0) {
            return false;
        }

        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (hasWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasWord(char[][] board, String word, int y, int x, int count) {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) {
            return false;
        }

        if (board[y][x] != word.charAt(count)) {
            return false;
        }

        if (count == word.length() - 1) {
            return true;
        }

        char c = board[y][x];
        board[y][x] = '$';

        boolean up = hasWord(board, word, y - 1, x, count + 1);
        if (up) {
            return true;
        }

        boolean down = hasWord(board, word, y + 1, x, count + 1);
        if (down) {
            return true;
        }

        boolean left = hasWord(board, word, y, x - 1, count + 1);
        if (left) {
            return true;
        }

        boolean right = hasWord(board, word, y, x + 1, count + 1);
        if (right) {
            return true;
        }
        board[y][x] = c;
        return false;
    }
}
