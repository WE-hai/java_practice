package 员工的重要性;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class  Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class Solution {
    public int dfs(Map<Integer,Employee> info,int id) {
        Employee curE = info.get(id);
        int curSum = curE.importance;
        for (int curId : curE.subordinates) {
            curSum += dfs(info,curId);
        }
        return curSum;
    }

    public int getImportance(List<Employee> employees,int id) {
        if (employees.isEmpty()) {
            return 0;
        }
        Map<Integer,Employee> info = new HashMap<>();
        for (Employee e : employees) {
            info.put(e.id,e);
        }
        return dfs(info,id);
    }
}
