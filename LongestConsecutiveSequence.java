import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers, find the length of the longest consecutive
elements sequence.

Your algorithm should run in O(n) complexity.

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    // Amortized O(n).
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Add all elements to the set.
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int length = 1;
            int val = nums[i];
            int num = nums[i];
            // Walk through the sequence. Remove the element from the set if
            // it exists. Also it makes sure the removed element will not be
            // visited again.
            while (set.contains(num - 1)) {
                length++;
                set.remove(num - 1);
                num--;
            }
            num = val;
            while (set.contains(num + 1)) {
                length++;
                set.remove(num + 1);
                num++;
            }
            set.remove(num);
            max = Math.max(max, length);
        }
        return max;
    }
}
