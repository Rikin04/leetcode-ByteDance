package ByteDance;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) return false;


        int length = s1.length();
        for (int i = 0; i < s1.length(); i ++) {

            String s3 = s2;
            int index = s2.indexOf(s1.charAt(i));

            while (index != -1) {
                if (index + length <= s3.length()) {
                    if (isEquals(s1, s3.substring(index, index + length))) return true;
                }
                s3 = s3.substring(index + 1, s3.length());
                index = s3.indexOf(s1.charAt(i));
            }

        }
        return false;
    }

    public boolean isEquals(String s1, String s2) { // 比较字符串是否是一种排列形式
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chars1);

        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] != chars1[i]) return false;
        }
        return true;
    }
}


