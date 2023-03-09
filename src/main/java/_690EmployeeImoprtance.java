import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class _690EmployeeImoprtance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    HashMap<Integer,Employee>empMap = new HashMap<>();
    public int dfs(int root){

        Employee e = empMap.get(root);
        int s = e.importance;

        List<Integer>subordinates = e.subordinates;
        ListIterator<Integer>ite = subordinates.listIterator();

        while(ite.hasNext()){
            s+=dfs(empMap.get(ite.next()).importance);
        }

        return s;
    }

    public int getImportance(List<Employee> employees, int id) {

        if(employees==null || employees.size()<1)return 0;

        for (Employee employee : employees) {
            empMap.put(employee.id,employee);
        }
        return dfs(id);
    }

    public static void main(String[] args) {

    }
}
