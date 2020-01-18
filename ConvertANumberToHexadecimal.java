/*
Given an integer, write an algorithm to convert it to hexadecimal. For negative
integer, two’s complement method is used.
 */
public class ConvertANumberToHexadecimal {
    //    public String toHex(int num) {
//        if (num == 0) {
//            return "0";
//        }
//        if (num > 0) {
//            return helper1(num);
//        }
//        // Special case.
//        if (num == -2147483648) {
//            return "80000000";
//        }
//        if (num < 0) {
//            return helper2(num);
//        }
//        throw new IllegalArgumentException();
//    }
//
//    private String helper1(int num) {
//        String s = "";
//        while (num != 0) {
//            int quotient = num / 16;
//            int remainder = num % 16;
//            if (remainder < 10) {
//                s = remainder + s;
//            } else {
//                s = ((char) ('a' + (remainder - 10))) + s;
//            }
//            num = quotient;
//        }
//        return s;
//    }
//
//    private String helper2(int num) {
//        String positive = helper1(Math.abs(num));
//        int length = 8 - positive.length();
//        for (int i = 0; i < length; i++) {
//            positive = 0 + positive;
//        }
//        String s = "";
//        int carry = 0;
//        for (int i = 7; i >= 0; i--) {
//            char hex = positive.charAt(i);
//            int digit = Character.isDigit(hex) ? hex - '0' : 10 + hex - 'a';
//            int res = 0 - digit + 16 - carry;
//            // 0 minus 0 with no carry situation.
//            if (res == 16) {
//                res = 0;
//            }
//            if (res == 0) {
//                carry = 0;
//            } else {
//                carry = 1;
//            }
//            if (res < 10) {
//                s = res + s;
//            } else {
//                s = ((char) ('a' + (res - 10))) + s;
//            }
//        }
//        return s;
//    }
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        // The integer is already in 2's complement form.
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8',
                '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String s = "";
        while (num != 0) {
            // Check every 4 digits.
            s = map[num & 15] + s;
            num = num >>> 4;
        }
        return s;
    }
}
