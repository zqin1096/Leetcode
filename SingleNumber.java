/*
Given a non-empty array of integers, every element appears twice except for one.
Find that single one.

Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?
 */
public class SingleNumber {
    // ^: XOR operator.
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
/*
    XOR
0 0 0
0 1 1
1 0 1
1 1 1
 */
