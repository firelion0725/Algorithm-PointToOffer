package com.leo.algorithm.work;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class ChangeWord {

    //easy 0ms 100%
    public String reverseLeftWords(String s, int n) {
        String result="";
        result+=s.substring(n);
        result+=s.substring(0,n);
        return result;
    }
}
