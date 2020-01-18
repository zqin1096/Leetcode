public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == 0 && i != arr.length - 1) {
                for (int j = arr.length - 2; j >= i + 1; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0;
                i++;
            }
            i++;
        }
    }
}
