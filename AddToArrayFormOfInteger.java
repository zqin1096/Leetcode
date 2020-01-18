import java.util.LinkedList;
import java.util.List;

/*
For a non-negative integer X, the array-form of X is an array of its digits in
left to right order.  For example, if X = 1231, then the array form is
[1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of
the integer X+K.
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int carry = 0;
        // Add 2 numbers.
        for (int i = A.length - 1; i >= 0; i--) {
            int num = A[i] + K % 10 + carry;
            carry = num / 10;
            K = K / 10;
            result.add(0, num % 10);
        }
        while (K != 0) {
            int num = K % 10 + carry;
            result.add(0, num % 10);
            carry = num / 10;
            K = K / 10;
        }
        // Check if carry is 1 at the end.
        if (carry == 1) {
            result.add(0, 1);
        }
        return result;
    }
}
