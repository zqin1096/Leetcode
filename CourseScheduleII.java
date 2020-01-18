import java.util.ArrayList;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the
ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If
it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {
    // Topological ordering.

    boolean isCyclic = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        // list[i]: prerequisites for course i.
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();
        // Maybe a disconnected graph.
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                findOrder(list, order, visiting, visited, i);
                if (isCyclic) {
                    return new int[]{};
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    private void findOrder(List<List<Integer>> prerequisites,
                           List<Integer> order,
                           boolean[] visiting, boolean[] visited, int course) {
        // Find a cycle.
        if (visiting[course]) {
            isCyclic = true;
            return;
        }
        visiting[course] = true;
        // If a course has no prerequisite, it means it can be taken first.
        for (Integer i : prerequisites.get(course)) {
            // Avoid repeated function call.
            if (visited[i]) {
                continue;
            }
            findOrder(prerequisites, order, visiting, visited, i);
        }
        // After visiting all its children, mark it as visited.
        visited[course] = true;
        visiting[course] = false;
        order.add(course);
    }
}
