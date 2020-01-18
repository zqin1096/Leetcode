public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(words[i] + "ma");
            } else {
                sb.append(words[i].substring(1) + words[i].charAt(0) + "ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
