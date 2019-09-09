package Longest;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class longestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                int value = map.get(ch);
                left = Math.max(left, value);
            }
            result = Math.max(result, right - left + 1);
            map.put(ch, right + 1); // Because my right = 0 at starting position , just for storing the values
        }
        return result;
    }


    public int lengthOfLongestSubstrings(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int left = 0, right = 0; left < s.length(); left++) {
            char ch = s.charAt(left);
            if (cache[ch] > 0) {
                right = Math.max(right, cache[ch]);
            } else {
                right = right;

            }
            cache[ch] = left + 1;
            result = Math.max(result, left - right + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        int left = new longestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str);
        System.out.println(left);


        int right = new longestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstrings(str);
        System.out.println(right);

    }
}
