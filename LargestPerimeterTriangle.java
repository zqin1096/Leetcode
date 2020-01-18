import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int a = A[A.length - 1];
        int b = A[A.length - 2];
        for (int i = A.length - 3; i >= 0; i--) {
            if (b + A[i] > a) {
                return a + b + A[i];
            } else {
                a = b;
                b = A[i];
            }
        }
        return 0;
    }
}
