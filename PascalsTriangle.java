import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> list = new LinkedList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new LinkedList<>();
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                row.add(j,
                        result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            row.add(i, 1);
            result.add(row);
        }
        return result;
    }
}
