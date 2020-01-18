/*
Given a positive integer, return its corresponding column title as appear in an
Excel sheet.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String s = "";
        while (n != 0) {
            // Use 0 - 25 to represent A - Z.
            int remainder = (n - 1) % 26;
            int quotient = (n - 1) / 26;
            char c = (char) ('A' + remainder);
            s = c + s;
            n = quotient;
        }
        return s;
    }
}
