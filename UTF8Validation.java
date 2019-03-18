package ByteDance;

public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        String[] strings = new String[data.length];
        for (int i = 0; i < strings.length; i ++)
            strings[i] = toBinaryString(data[i]);

        int i = 0;
        while (i < strings.length) {
            if (strings[i].charAt(0) == '0') i ++;
            else if (strings[i].substring(0, 2).equals("10")) return false;
            else {
                int zero = strings[i].indexOf('0');
                if (zero == -1 || zero > 4)  return false;
                for (int x = 1; x < zero; x ++) {
                    if (i + x >= strings.length) return false;
                    if (!strings[i + x].substring(0, 2).equals("10")) return false;
                }
                i += zero;
            }
        }
        return true;
    }
    public String toBinaryString(int n) {
        String str = "";
        for (int i = 0; i < 8; i ++) {
            str = n % 2 + str;
            n = n >> 1;
        }
        return str;
    }
}

