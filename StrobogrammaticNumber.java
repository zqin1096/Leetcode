/*
A strobogrammatic number is a number that looks the same when rotated 180
degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is
represented as a string.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] ch = num.toCharArray();
        int length = num.length() - 1;
        for (int i = 0; i <= num.length() / 2; i++) {
            if (ch[i] == '0') {
                if (ch[length - i] != '0') {
                    return false;
                }
            } else if (ch[i] == '1') {
                if (ch[length - i] != '1') {
                    return false;
                }
            } else if (ch[i] == '2' || ch[i] == '3' || ch[i] == '4' || ch[i]
                    == '5' || ch[i] == '7') {
                return false;
            } else if (ch[i] == '6') {
                if (ch[length - i] != '9') {
                    return false;
                }
            } else if (ch[i] == '8') {
                if (ch[length - i] != '8') {
                    return false;
                }
            } else {
                if (ch[length - i] != '6') {
                    return false;
                }
            }
        }
        return true;
    }
}
