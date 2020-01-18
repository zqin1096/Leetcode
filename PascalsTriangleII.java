import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative index k where k ≤ 33, return the kth index row of the
Pascal's triangle.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            temp.add(1);
            for (int j = 1; j <= i - 1; j++) {
                int num = result.get(j - 1) + result.get(j);
                temp.add(j, num);
            }
            result = temp;
        }
        return result;
    }
}
