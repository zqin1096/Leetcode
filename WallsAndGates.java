import java.util.LinkedList;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
represent INF as you may assume that the distance to a gate is less than
2147483647.
 */
public class WallsAndGates {

    // TLE.
//    private class Pair {
//
//        int[] position;
//        int distanceToNearestGate;
//
//        Pair(int[] position, int distanceToNearestGate) {
//            this.position = position;
//            this.distanceToNearestGate = distanceToNearestGate;
//        }
//    }
//
//    public void wallsAndGates(int[][] rooms) {
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[i].length; j++) {
//                if (rooms[i][j] == 0) {
//                    bfs(rooms, new int[]{i, j},
//                            new boolean[rooms.length][rooms[0].length]);
//                }
//            }
//        }
//    }
//
//    private void bfs(int[][] rooms, int[] gate, boolean[][] visited) {
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(gate, 0));
//        while (!queue.isEmpty()) {
//            Pair room = queue.remove();
//            rooms[room.position[0]][room.position[1]] =
//                    Math.min(rooms[room.position[0]][room.position[1]],
//                            room.distanceToNearestGate);
//            visited[room.position[0]][room.position[1]] = true;
//            int up = room.position[0] - 1;
//            if (up >= 0 && !visited[up][room.position[1]] && rooms[up][room.position[1]] != -1) {
//                queue.add(new Pair(new int[]{up, room.position[1]},
//                        room.distanceToNearestGate + 1));
//            }
//            int down = room.position[0] + 1;
//            if (down < rooms.length && !visited[down][room.position[1]] && rooms[down][room.position[1]] != -1) {
//                queue.add(new Pair(new int[]{down, room.position[1]},
//                        room.distanceToNearestGate + 1));
//            }
//            int left = room.position[1] - 1;
//            if (left >= 0 && !visited[room.position[0]][left] && rooms[room.position[0]][left] != -1) {
//                queue.add(new Pair(new int[]{room.position[0], left},
//                        room.distanceToNearestGate + 1));
//            }
//            int right = room.position[1] + 1;
//            if (right < rooms[0].length && !visited[room.position[0]][right] && rooms[room.position[0]][right] != -1) {
//                queue.add(new Pair(new int[]{room.position[0], right},
//                        room.distanceToNearestGate + 1));
//            }
//        }
//    }
//    public void wallsAndGates(int[][] rooms) {
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[i].length; j++) {
//                if (rooms[i][j] == 0) {
//                    bfs(rooms, new int[]{i, j, 0},
//                            new boolean[rooms.length][rooms[0].length]);
//                }
//            }
//        }
//    }
//
//    private void bfs(int[][] rooms, int[] gate, boolean[][] visited) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(gate);
//        while (!queue.isEmpty()) {
//            int[] room = queue.remove();
//            rooms[room[0]][room[1]] = Math.min(rooms[room[0]][room[1]],
//                    room[2]);
//            visited[room[0]][room[1]] = true;
//            if (room[0] - 1 >= 0 && !visited[room[0] - 1][room[1]] && rooms[room[0] - 1][room[1]] != -1) {
//                queue.add(new int[]{room[0] - 1, room[1], room[2] + 1});
//            }
//            if (room[0] + 1 < rooms.length && !visited[room[0] + 1][room[1]] && rooms[room[0] + 1][room[1]] != -1) {
//                queue.add(new int[]{room[0] + 1, room[1], room[2] + 1});
//            }
//            if (room[1] - 1 >= 0 && !visited[room[0]][room[1] - 1] && rooms[room[0]][room[1] - 1] != -1) {
//                queue.add(new int[]{room[0], room[1] - 1, room[2] + 1});
//            }
//            if (room[1] + 1 < rooms[0].length && !visited[room[0]][room[1] + 1] && rooms[room[0]][room[1] + 1] != -1) {
//                queue.add(new int[]{room[0], room[1] + 1, room[2] + 1});
//            }
//        }
//    }
    // We can search from all gates at the same time.
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        while (!queue.isEmpty()) {
            int[] room = queue.remove();
            rooms[room[0]][room[1]] = Math.min(rooms[room[0]][room[1]],
                    room[2]);
            visited[room[0]][room[1]] = true;
            if (room[0] - 1 >= 0 && !visited[room[0] - 1][room[1]] && rooms[room[0] - 1][room[1]] != -1) {
                queue.add(new int[]{room[0] - 1, room[1], room[2] + 1});
            }
            if (room[0] + 1 < rooms.length && !visited[room[0] + 1][room[1]] && rooms[room[0] + 1][room[1]] != -1) {
                queue.add(new int[]{room[0] + 1, room[1], room[2] + 1});
            }
            if (room[1] - 1 >= 0 && !visited[room[0]][room[1] - 1] && rooms[room[0]][room[1] - 1] != -1) {
                queue.add(new int[]{room[0], room[1] - 1, room[2] + 1});
            }
            if (room[1] + 1 < rooms[0].length && !visited[room[0]][room[1] + 1] && rooms[room[0]][room[1] + 1] != -1) {
                queue.add(new int[]{room[0], room[1] + 1, room[2] + 1});
            }
        }
    }
}
/*
    DFS solution.
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
    }

    private void dfs(int[][] rooms, int i, int j, int d) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
        rooms[i][j] = d;
        dfs(rooms, i - 1, j, d + 1);
        dfs(rooms, i + 1, j, d + 1);
        dfs(rooms, i, j - 1, d + 1);
        dfs(rooms, i, j + 1, d + 1);
    }
    */
