import java.util.LinkedList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible
valid IP address combinations.
 */
public class RestoreIPAddresses {
    // DFS.
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        dfs(new LinkedList<Integer>(), s, result);
        return result;
    }

    private void dfs(List<Integer> list, String s, List<String> result) {
        if (list.size() >= 4 && !s.equals("")) {
            return;
        }
        if (list.size() == 4 && s.equals("")) {
            String ip = String.valueOf(list.get(0));
            for (int i = 1; i < 4; i++) {
                ip += ".";
                ip += list.get(i);
            }
            result.add(ip);
            return;
        }
        // Compute the range.
        int range = Math.min(3, s.length());
        // i represents the length of each part. The maximum length is 3.
        for (int i = 1; i <= range; i++) {
            String subnet = s.substring(0, 0 + i);
            // If the length of the subnet is larger than 1, then the most
            // significant digit cannot be 0.
            if (subnet.length() != 1 && subnet.charAt(0) == '0') {
                return;
            }
            if (Integer.parseInt(subnet) > 255) {
                return;
            } else {
                list.add(Integer.parseInt(subnet));
                // Pass in the remaining s.
                dfs(list, s.substring(0 + i), result);
                list.remove(list.size() - 1);
            }
        }
    }
}
                    