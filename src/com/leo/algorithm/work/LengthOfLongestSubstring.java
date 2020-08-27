package com.leo.algorithm.work;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int res = l.test(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) {
                i--;
            } // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    //双指针滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(right + 1));
                right++;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    private int test(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();

        int right = 0;
        int res = 1;
        set.add(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right+1));
                right++;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }

}
