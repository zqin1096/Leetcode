import java.util.*;

/*
You are given a data structure of employee information, which includes the
employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the
leader of employee 3. They have importance value 15, 10 and 5, respectively.
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
[2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is
also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need
to return the total importance value of this employee and all his subordinates.

One employee has at most one direct leader and may have several subordinates.
 */
public class EmployeeImportance {

    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        int id;
        // the importance value of this employee
        int importance;
        // the id of direct subordinates
        List<Integer> subordinates;

        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    int ans = 0;
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        // Since one employee has at most 1 direct leader, we do not need to
        // keep track which employees are searched.
        dfs(map.get(id));
        return ans;
    }

    private void dfs(Employee employee) {
        ans += employee.importance;
        for (int i = 0; i < employee.subordinates.size(); i++) {
            dfs(map.get(employee.subordinates.get(i)));
        }
    }
}
