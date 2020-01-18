import java.util.*;

/*
You have a lock in front of you with 4 circular wheels. Each wheel has 10
slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate
freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4
wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of
these codes, the wheels of the lock will stop turning and you will be unable to
open it.

Given a target representing the value of the wheels that will unlock the lock,
return the minimum total number of turns required to open the lock, or -1 if it
is impossible.
 */
public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        if (set.contains("0000")) {
            return -1;
        }
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        map.put("0000", 0);
        queue.add("0000");
        while (!queue.isEmpty()) {
            String code = queue.remove();
            if (code.equals(target)) {
                return map.get(code);
            }
            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder(code);
                int num = sb.charAt(i) - '0';
                int clockwise = (num + 1) % 10;
                sb.deleteCharAt(i);
                sb.insert(i, clockwise);
                if (!set.contains(sb.toString()) && !map.containsKey(sb.toString())) {
                    map.put(sb.toString(), map.get(code) + 1);
                    queue.add(sb.toString());
                    System.out.println(sb.toString());
                }
                sb = new StringBuilder(code);
                int counterclockwise = (num - 1 + 10) % 10;
                sb.deleteCharAt(i);
                sb.insert(i, counterclockwise);
                if (!set.contains(sb.toString()) && !map.containsKey(sb.toString())) {
                    map.put(sb.toString(), map.get(code) + 1);
                    queue.add(sb.toString());
                    System.out.println(sb.toString());
                }
            }
        }
        return -1;
    }
}
