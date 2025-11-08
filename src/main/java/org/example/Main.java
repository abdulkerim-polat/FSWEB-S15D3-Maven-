package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
  private static Map<Integer, Employee> employeeMap;
  private static List<Employee> dumplicatedEmployee;

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<Employee>();
        employees.add(new Employee(1, "Ali", "Koç"));
        employees.add(new Employee(2, "Veli", "Con"));
        employees.add(new Employee(3, "Sabri", "Dal"));
        employees.add(new Employee(2, "Veli", "Con"));
        employees.add(new Employee(3, "Zühtü", "Bek"));

    }
    public static List<Employee> findDuplicates(List<Employee> employees){
    employeeMap = new HashMap<>();
    dumplicatedEmployee = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                dumplicatedEmployee.add(employee);
            }
            else {
                employeeMap.put((int) employee.getId(), employee);
            }
        }
        return dumplicatedEmployee;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put((int) employee.getId(), employee);
            }
        }
        return employeeMap;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUniques = new LinkedList<>(uniques.values());
        onlyUniques.removeAll(duplicates);
        return onlyUniques;
    }
}