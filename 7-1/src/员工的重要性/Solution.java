package 员工的重要性;

import java.util.*;

public class Solution {
    public int getImportance(List<Employee> employees,int id) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        //初始化队列
        q.offer(id);
        //把员工信息保存在map中，方便查询
        Map<Integer,Employee> m = new HashMap<>();
        for (Employee e : employees) {
            m.put(e.id,e);
        }
        //遍历队列
        while (!q.isEmpty()) {
            int t = q.peek();
            q.poll();
            res += m.get(t).importance;
            for (int num : m.get(t).subordinates) {
                q.offer(num);
            }
        }
        return res;
    }
}
