package ByteDance;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        if (num1.length() > num2.length()) {
            String num3 = num1;
            num1 = num2;
            num2 = num3;
        }

        int[][] number = new int[num1.length()][num2.length() + 1];

        for (int x = num1.length() - 1; x >= 0; x --) {
            int carry = 0;
            for (int y = num2.length(); y > 0; y --) {
                int sum = Integer.parseInt(num1.charAt(x) + "") * Integer.parseInt(num2.charAt(y - 1) + "");
                int ten = sum / 10;
                int simple = sum % 10;
                number[x][y] = (simple + carry) % 10;
                carry = ten + (simple + carry) / 10;
            }
            number[x][0] = carry;
        }

        String string = "";

        for (int i = 0; i < number[0].length; i ++)
            string += number[0][i];

        for (int x = 1; x < number.length; x ++) {

            int i = string.length() - 1;
            int carry = 0;

            for (int y = number[x].length - 2; y >= 0; y --) {
                int sum = number[x][y] + Integer.parseInt(string.substring(i, i + 1));
                int ten = sum / 10;
                int simple = sum % 10;
                int s = (simple + carry) % 10;
                string = string.substring(0, i) + s + string.substring(i + 1, string.length());
                carry = (simple + carry) / 10 + ten;
                i --;
            }
            while (i >= 0) {
                int num = carry + Integer.parseInt(string.substring(i, i + 1));
                carry = num / 10;
                int simple = num % 10;
                if (i == 0) string = simple + string.substring(1, string.length());
                else
                    string = string.substring(0, i) + simple + string.substring(i + 1, string.length());
                i --;
            }
            if (carry != 0) string = carry + string;
            string += number[x][number[x].length - 1];

        }

        for (int i = 0; i < string.length(); i ++) {
            if (string.charAt(0) != '0') break;
            else string = string.substring(i + 1, string.length());
        }

        return string;

    }
}

