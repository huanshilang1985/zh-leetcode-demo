package com.zh.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 算法题3：无重复字符的最长子串
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * 这个题是自己写的
 * @author he.zhang
 * @date 2020/2/20 17:42
 */
public class question3_strLength {

    public int lengthOfLongestSubstring(String s) throws Exception {
        int length = 0;
        char[] chars = s.toCharArray();
        // 有序map
        Map<Character, Character> map = new LinkedHashMap<>(s.length());
        for (char c : chars) {
            if (map.containsKey(c)) {
                if (map.size() > length) {
                    length = map.size();
                }
                // 把重复字符之前的map值记录下来
                List<Character> removeList = new ArrayList<>(map.size());
                for (Character key : map.keySet()) {
                    removeList.add(key);
                    if (key.equals(c)) {
                        break;
                    }
                }
                // map删除这些key
                for(Character key : removeList){
                    map.remove(key);
                }
            }
            map.put(c, c);
        }
        // 输出前再判断一次
        if (map.size() > length) {
            length = map.size();
        }
        return length;
    }

    public static void main(String[] args) {
        try {
            String str = "aab";
            question3_strLength q = new question3_strLength();
            int i = q.lengthOfLongestSubstring(str);
            System.out.println("操作结果：" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
