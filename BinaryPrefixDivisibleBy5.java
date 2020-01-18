import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            // Avoid overflow.
            num = (2 * num + A[i]) % 5;
            if (num == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
