import java.util.*;

public class PowerfulIntegers {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        // Boundary check.
        int i = x == 1 ? 1 : (int) (Math.log(bound) / Math.log(x));
        int j = y == 1 ? 1 : (int) (Math.log(bound) / Math.log(y));
        Set<Integer> result = new HashSet<>();
        int sum = 0;
        for (int a = 0; a <= i; a++) {
            for (int b = 0; b <= j; b++) {
                sum = (int) Math.pow(x, a) + (int) Math.pow(y, b);
                System.out.println(sum);
                if (sum <= bound) {
                    result.add(sum);
                }

            }
        }
        return new ArrayList<>(result);
    }
}
