package Streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Department backend = new Department(1,"Backend Developer");
        Department testing = new Department(2,"Testing");
        Department support = new Department(3,"Application Support");
        Department hr  = new Department(4,"HR");

        List<Employee> employees = Arrays.asList(new Employee(1,"Charan",60000,backend),
                new Employee(2,"Harshith",90000,testing),
                new Employee(3,"Yugandhar",70000.00,testing),
                new Employee(4,"Lakshman",95000.00,backend),
                new Employee(5,"Ajay",76000.00,backend),
                new Employee(6,"Yagyna",60000.00,support),
                new Employee(7,"Shwetha",60000.00,testing),
                new Employee(8,"Bindu",65000.00,support),
                new Employee(9,"Balaji",68000.00,backend),
                new Employee(10,"Murali",50000.00,support),
                new Employee(11,"Chaitanya",50000,hr)
                );
        // Natural Sorting Order
        employees.sort(Comparator.comparing(Employee::getName));
        employees.forEach(System.out::println);
        System.out.println("==========================================================================================");
        // Descending Order of names
        employees.sort(Comparator.comparing(Employee::getName).reversed());
        employees.forEach(System.out::println);
        System.out.println("==========================================================================================");
        // Count of Employees based on Department
        Map<Department,Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        map.forEach((key,value)-> System.out.println(key.getName()+" :: "+value));
        System.out.println("==========================================================================================");
        // Highest Salary of an Employee
        Optional<Employee> highestSalary = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        highestSalary.ifPresent(e-> System.out.println("Highest salaried Employee "+e));
        System.out.println("==========================================================================================");
        // Top 2 Highest Salary From Each Department
        Map<Department,List<Employee>> res = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                empList -> empList.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .limit(2)
                                        .collect(Collectors.toList())
                        ))
               );
        res.forEach((department,employee)-> {
            System.out.println(department.getName());
            employee.forEach(e -> System.out.println(e));
        });
    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    private Department department;

    public Employee(int id,String name,double salary,Department department){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public String toString(){
        return "Employee  { id = "+id+", name = "+name+", salary = "+salary+", department = "+department.getName()+"}";
    }
}

class Department{
    private int id;
    private String name;

    Department(int id,String name){
        this.id  = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Department { id = "+id+", name = "+name+"}";
    }
}
