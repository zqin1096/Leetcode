/*
Given a year Y and a month M, return how many days there are in that month.
 */
public class NumberOfDaysInAMonth {
    int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int numberOfDays(int Y, int M) {
        if (Y % 400 == 0 || (Y % 4 == 0 && Y % 100 != 0)) {
            return M == 2 ? days[M - 1] + 1 : days[M - 1];
        } else {
            return days[M - 1];
        }
    }
}
