package com.yy.arithmetic.seqtember;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

/**
 * @author Ivan yu
 * @date 2020/08/26
 */
public class Solution {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        return null;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)){
            return 0;
        }
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 1;
        for (int i = 0; i < length; i++) {
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            left = i;
            while (right < length && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length, ins = 0;
        if(length == 0){
            return "";
        }
        String base = strs[0];
        if(length == 1){
            return base;
        }
        String prefix = base;
        for (int i = 1; i < length; i++) {
            String str = strs[i];
            prefix = findPrefix(prefix, str);
            if("".equals(prefix)){
                return prefix;
            }
        }
        return prefix;
    }

    public static String findPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        String prefix = "";
        if(length == 0){
            return prefix;
        }
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            prefix = str1.substring(0,index + 1);
            index++;
        }
        return prefix;
    }
//n*n  n*(n-1)*(n-2)
    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     */
    public boolean checkInclusion(String s1, String s2) {
        List<String> permutations = permutation(s1);
        int size = permutations.size();
        for (int i = 0; i < size; i++) {
            if(s2.contains(permutations.get(i))){
                return true;
            }
        }
        return false;
    }

    List<String> res = new LinkedList<>();
    char[] c;
    public List<String> permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    public static void main(String[] args) {
        String s = "abcd";
        BigInteger i = new BigInteger("34242342424151787171111");
        Solution solution = new Solution();



    }
}
