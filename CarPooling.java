import java.util.*;

/*
You are driving a vehicle that has capacity empty seats initially available for
passengers.  The vehicle only drives east (ie. it cannot turn around and drive
west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location]
contains information about the i-th trip: the number of passengers that must be
picked up, and the locations to pick them up and drop them off.  The locations
are given as the number of kilometers due east from your vehicle's initial
location.

Return true if and only if it is possible to pick up and drop off all
passengers for all the given trips.
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // map: (A time point, number of seats taken).
        // If the value is negative, it means that number of seats are
        // available again.
        // We can also use TreeMap to avoid sorting. We want to track the
        // changes of the number of passengers in the time order (really
        // important).
        Map<Integer, Integer> map = new HashMap<>();
        int available = capacity;
        for (int[] trip : trips) {
            if (map.containsKey(trip[1])) {
                map.put(trip[1], map.get(trip[1]) + trip[0]);
            } else {
                map.put(trip[1], trip[0]);
            }
            if (map.containsKey(trip[2])) {
                map.put(trip[2], map.get(trip[2]) - trip[0]);
            } else {
                map.put(trip[2], -trip[0]);
            }
        }
        Set<Map.Entry<Integer, Integer>> pairs = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(pairs);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            // Sort the entries according to the time point (key). We want to
            // update the available seats in the time order. 按照时间顺序来更新
            // 座位的数量.不能先加后面时间时座位的变化,再去加前面时间座位的变化.
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Integer, Integer> seat : list) {
            available -= seat.getValue();
            if (available < 0) {
                return false;
            }
        }
        return true;
    }
}
