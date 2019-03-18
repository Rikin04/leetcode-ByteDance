package ByteDance;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] str = s.split(" ");

        String s1 = "";

        for (int i = str.length - 1; i >= 0; i --) {
            s1 = s1 + " " + str[i];
            s1 = s1.trim();
        }

        return s1;

    }
}

