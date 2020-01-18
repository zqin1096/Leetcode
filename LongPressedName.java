public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        char pre = '\0';
        char[] ch1 = name.toCharArray();
        char[] ch2 = typed.toCharArray();
        while (i < ch1.length && j < ch2.length) {
            if (ch1[i] == ch2[j]) {
                pre = ch1[i];
                i++;
                j++;
            } else {
                if (ch2[j] == pre) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        if (i != ch1.length && j == ch2.length) {
            return false;
        }
        while (j < ch2.length) {
            if (ch2[j] != pre) {
                return false;
            }
            j++;
        }
        return true;
    }
}
