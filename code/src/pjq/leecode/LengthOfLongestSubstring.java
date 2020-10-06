package pjq.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长子串：
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int length = s.length();
        int rk = -1; //右指针
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !hashSet.contains(s.charAt(rk + 1))) {
                hashSet.add(s.charAt(rk + 1));
                rk++;
            }
            max = Math.max(max, rk + 1 - i);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ""; //abcabcbb:3;  bbbbb:1;  pwwkew:3
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        int max = obj.lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}
