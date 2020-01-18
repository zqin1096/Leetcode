public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int start = 0;
        int end = S.length() - 1;
        char[] ch = S.toCharArray();
        while (start < end) {
            if (Character.isLetter(ch[start]) && Character.isLetter(ch[end])) {
                char c = ch[start];
                ch[start++] = ch[end];
                ch[end--] = c;
            } else if (Character.isLetter(ch[start]) && !Character.isLetter(ch[end])) {
                end--;
            } else if (!Character.isLetter(ch[start]) && Character.isLetter(ch[end])) {
                start++;
            } else {
                start++;
                end--;
            }
        }
        return String.valueOf(ch);
    }
}
