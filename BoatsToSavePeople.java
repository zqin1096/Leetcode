import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        // Greedy. If the heaviest person can share a boat with the lightest person, then do so.
        Arrays.sort(people);
        // Current lightest people.
        int i = 0;
        // Current heaviest people.
        int j = people.length - 1;
        int ans = 0;
        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return ans;
    }
}
