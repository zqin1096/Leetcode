import java.util.ArrayList;
import java.util.List;

/*

Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order
of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in
succession) to sort the array A. Return the k-values corresponding to a sequence of pancake flips that sort A.  Any
valid answer that sorts the array within 10 * A.length flips will be judged as correct.

*/
public class PancakeSorting {
    public static List<Integer> pancakeSort(int[] A) {
        int max = A.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            // Find the current maximum number.
            for (int j = 0; j < A.length; j++) {
                if (A[j] == max) {
                    // If the current maximum number is already at the correct place, there is no need to flip.
                    if (j != max - 1) {
                        int start = 0;
                        int end = j;
                        // Reverse the first j + 1 elements so the current maximum number is placed at index 0;
                        while (start < end) {
                            int temp = A[start];
                            A[start] = A[end];
                            A[end] = temp;
                            start++;
                            end--;
                        }
                        // Reverse the first max elements so the current maximum number is placed at the correct place.
                        result.add(j + 1);
                        start = 0;
                        end = max - 1;
                        while (start < end) {
                            int temp = A[start];
                            A[start] = A[end];
                            A[end] = temp;
                            start++;
                            end--;
                        }
                        result.add(max);
                    }
                    max--;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = pancakeSort(new int[]{2, 1, 3});
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
