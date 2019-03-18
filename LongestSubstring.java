package ByteDance;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

        int max = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        String s1 = "";
        for (int i = 0; i < chars.length; i ++) {
            if (s1.indexOf(chars[i]) != -1) {
                int index = s1.indexOf(chars[i]);
                s1 = s1.substring(index + 1, s1.length()) + chars[i];
            }
            else {
                s1 = s1 + chars[i];
                if (max < s1.length()) max = s1.length();
            }
        }

        return max;
    }
}

