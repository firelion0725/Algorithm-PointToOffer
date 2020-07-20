package com.leo.algorithm.work;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class ReverseWords {

    public static void main(String[] args) {
        String str = "  hello   world!  ";
        ReverseWords r = new ReverseWords();
        r.reverseWords(str);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] strings = s.trim().split(" ");
        int left = 0;
        int right = strings.length - 1;
        while (left < right) {
            swap(strings, left, right);
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            if (!string.equals(" ") && !string.equals("")) {
                sb.append(string);
                sb.append(" ");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void swap(String[] strings, int index1, int index2) {
        if (index1 < 0 || index1 > strings.length - 1 || index2 < 0 || index2 > strings.length - 1 || index1 == index2) {
            return;
        }
        String temp = strings[index1];
        strings[index1] = strings[index2];
        strings[index2] = temp;
    }

}
