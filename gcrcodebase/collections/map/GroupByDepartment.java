package week04.gcrcodebase.collections.map;

import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

class GroupByDepartment {
	static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            //department is not present, create a new list
            if (!map.containsKey(e.department)) {
                map.put(e.department, new ArrayList<>());
            }

            //employee to the correct department list
            map.get(e.department).add(e);
        }

        return map;
    }
	
	
	
	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> result = groupByDepartment(employees);

        for (String dept : result.keySet()) {
            System.out.println(dept + ": " + result.get(dept));
        }
    }

}
