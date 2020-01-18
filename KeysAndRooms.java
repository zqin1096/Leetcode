import java.util.List;

/*
There are N rooms and you start in room 0.  Each room has a distinct number in
0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is
an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v
opens the room with number v.

Initially, all the rooms start locked (except for room 0).
You can walk back and forth between rooms freely.
Return true if and only if you can enter every room.

 */
public class KeysAndRooms {
    int num = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(new boolean[rooms.size()], rooms, 0);
        return num == rooms.size();
    }

    private void dfs(boolean[] visited, List<List<Integer>> rooms, int room) {
        if (visited[room]) {
            return;
        }
        visited[room] = true;
        num++;
        // Go to the rooms with the keys.
        for (int i = 0; i < rooms.get(room).size(); i++) {
            dfs(visited, rooms, rooms.get(room).get(i));
        }
    }
}
