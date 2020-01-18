import java.util.HashSet;
import java.util.Set;

/*
The set S originally contains numbers from 1 to n. But unfortunately, due to
the data error, one of the numbers in the set got duplicated to another number
in the set, which results in repetition of one number and loss of another
number.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = (1 + nums.length) * nums.length / 2;
        int curr = 0;
        int[] result = new int[2];
        for (int num : nums) {
            if (set.contains(num)) {
                result[0] = num;
            } else {
                set.add(num);
                curr += num;
            }
        }
        result[1] = sum - curr;
        return result;
    }
}
