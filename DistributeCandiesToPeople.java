import java.util.Map;

public class DistributeCandiesToPeople {
    // Prevent brute-force O(n^2).
    public int[] distributeCandies(int candies, int num_people) {
        // i - 1 represents the (i - 1)th distribution and i represents the
        // number of candies to give in that distribution.
        int[] result = new int[num_people];
        for (int i = 1; candies > 0; ) {
            // The last person will receive all of our remaining candies (not
            // necessarily one more than the previous gift).
            result[(i - 1) % num_people] += Math.min(candies, i);
            candies = candies - i;
            i++;
        }
        return result;
    }
}
