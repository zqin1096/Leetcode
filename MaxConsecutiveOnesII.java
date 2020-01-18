public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Sliding window & two pointers.
        int max = 0;
        int start = 0;
        int end = 0;
        boolean flip = false;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else {
                if (!flip) {
                    flip = true;
                    end++;
                } else {
                    while (nums[start] != 0) {
                        start++;
                    }
                    start++;
                    end++;
                }
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
}
