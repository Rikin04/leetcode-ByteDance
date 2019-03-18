package ByteDance;

public class LongestCommonPrefixStrin {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        if (strs.length == 1) return strs[0];

        String maxPrefixString = "";

        for (int i = 1; i <= strs[0].length(); i ++) {
            String prefixString = strs[0].substring(0, i);
            boolean b = true;
            for (int x = 1; x < strs.length; x ++) {
                if (i > strs[x].length() || !prefixString.equals(strs[x].substring(0, i))) {
                    b = false;
                    break;
                }
            }
            if (b)
                maxPrefixString = prefixString;
            else break;
        }

        return maxPrefixString;
    }
}

