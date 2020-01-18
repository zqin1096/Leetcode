import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {

    // Store all the snapshots.
    List<Map<Integer, Integer>> snapshots;
    // Store all the changes before snap() call.
    Map<Integer, Integer> changes;

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        changes = new HashMap<>();
    }

    public void set(int index, int val) {
        changes.put(index, val);
    }

    public int snap() {
        // Add the changes to the snapshots.
        snapshots.add(changes);
        // Reset the changes.
        changes = new HashMap<>();
        return snapshots.size() - 1;
    }

    public int get(int index, int snap_id) {
        // Start searching from the version snap_id. If the current snapshot
        // does not have index as a key, it means that value was not changed
        // in this snapshot, and we need to search the previous snapshots.
        for (int i = snap_id; i >= 0; i--) {
            if (snapshots.get(i).containsKey(index)) {
                return snapshots.get(i).get(index);
            }
        }
        return 0;
    }
}
