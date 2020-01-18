import java.util.*;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> number = new HashSet<>();
        // i represents the most significant digit.
        for (int i = 0; i <= 9; i++) {
            if (N != 1 && i == 0) {
                continue;
            }
            numsSameConsecDiff(N, K, 1, new StringBuilder().append(i), number);
        }
        int[] result = new int[number.size()];
        int index = 0;
        for (int i : number) {
            result[index++] = i;
        }
        return result;
    }

    // Backtracking.
    private void numsSameConsecDiff(int N, int K, int index, StringBuilder sb, Set<Integer> set) {
        if (index == N) {
            set.add(Integer.valueOf(sb.toString()));
            return;
        }
        int number1 = sb.charAt(sb.length() - 1) - '0' + K;
        if (number1 >= 0 && number1 <= 9) {
            sb.append(number1);
            numsSameConsecDiff(N, K, index + 1, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
        int number2 = sb.charAt(sb.length() - 1) - '0' - K;
        if (number2 >= 0 && number2 <= 9) {
            sb.append(number2);
            numsSameConsecDiff(N, K, index + 1, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
