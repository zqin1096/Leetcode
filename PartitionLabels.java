import java.util.*;

public class PartitionLabels {
    // Similar to merge intervals.
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Interval[] intervals = new Interval[26];
        // Find the start index and end index of each letter.
        for (int i = 0; i < S.length(); i++) {
            if (intervals[S.charAt(i) - 'a'] == null) {
                intervals[S.charAt(i) - 'a'] = new Interval(i, i);
            } else {
                intervals[S.charAt(i) - 'a'].end = i;
            }
        }
        List<Interval> letters = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] != null) {
                letters.add(intervals[i]);
            }
        }
        // Sort intervals based on the start index.
        Collections.sort(letters, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = letters.get(0).start;
        int end = letters.get(0).end;
        for (int i = 1; i < letters.size(); i++) {
            // If the start value is larger than the end value, a non-overlapping interval is found.
            if (letters.get(i).start <= end) {
                end = Math.max(end, letters.get(i).end);
            } else {
                result.add(end - start + 1);
                start = letters.get(i).start;
                end = letters.get(i).end;
            }
        }
        result.add(end - start + 1);
        return result;
    }

    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
