import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    // DFS.
    // Detect if a cycle exists in a directed graph.
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        // Get the prerequisites for each course.
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // Important to use both visited and visiting.
        // visited: avoid redundant check.
        // visiting: check cycle.
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                // If a cycle exists, return false directly.
                if (isCyclic(list, visited, visiting, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> prerequisites, boolean[] visited, boolean[] visiting, int course) {
        // Current course.
        visiting[course] = true;
        // Check all its prerequisites.
        for (Integer i : prerequisites.get(course)) {
            // If the course is already checked, continue to the next course.
            if (visited[i]) {
                continue;
            }
            // If the course i is visited twice "on the current path", then
            // there is a cycle from course i to i.
            if (visiting[i]) {
                return true;
            }
            if (isCyclic(prerequisites, visited, visiting, i)) {
                return true;
            }
        }
        // Done visiting.
        visiting[course] = false;
        // All prerequisites are checked, meaning this course is done. There
        // is no cycle back to this course.
        visited[course] = true;
        return false;
    }
}
