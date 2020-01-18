import java.util.ArrayList;
import java.util.List;

// If A is a beautiful array, then A - 1 (all elements are decreased by 1) and A * 2 (all elements are multiplied by 2)
// are also beautiful arrays.
public class BeautifulArray {
    public int[] beautifulArray(int N) {
        List<Integer> list = new ArrayList<>();
        // 1 itself is a beautiful array.
        list.add(1);
        while (list.size() < N) {
            List<Integer> temp = new ArrayList<>();
            // The odd part itself is beautiful array. The even part itself is beautiful array.
            // Even number plus odd number is odd number, which is not divisible by 2.
            // Put odd numbers at the left side of the array.
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) * 2 - 1 <= N) {
                    temp.add(list.get(i) * 2 - 1);
                }
            }
            // Put even numbers at the right side of the array.
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) * 2 <= N) {
                    temp.add(list.get(i) * 2);
                }
            }
            list = temp;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    /*
    [1]: beautiful array.
    [1], [2] -> [1, 2]

    [1, 2]
    [1, 3], [2, 4] -> [1, 3, 2, 4]
    Since [1] is a beautiful array, [2] is a beautiful array, [1, 2] is
    guaranteed to be a beautiful array. Put odd numbers at one side, put even
     numbers at another side. The odd numbers part and even numbers part are
     guaranteed to be beautiful arrays since they are built from beautiful
     array.
     */
}
