package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFilterReduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,4,6,8,10);

        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        int sum1 = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        Integer max = list.stream().reduce(Integer::max).get();
        System.out.println(max);

        Integer maxLambda = list.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxLambda);

        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        System.out.println(average.getAsDouble());

        long count = list.stream().mapToInt(Integer::intValue).count();
        System.out.println(count);

        List<Integer> collect = list.stream().map(n -> n + 1).skip(2).collect(Collectors.toList());
        System.out.println(collect);

        List<String> string = Arrays.asList("one","two","three","four","five");
        String s = string.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println(s);
        List<Worker> workers = Arrays.asList(new Worker(101,"Charan","A",60000),
                new Worker(102,"Rupjit","C",80000),
                new Worker(103,"Ritham","A",70000),
                new Worker(104,"Balaji","B",70000),
                new Worker(105,"Murali","C",80000),
                new Worker(106,"Ajay","A",80000));
        Double avg = workers.stream().filter(e1 -> e1.getGrade().equals("A")).mapToDouble(e1 -> e1.getSalary()).average().getAsDouble();
        System.out.println(avg);
    }
}

class Worker{
    private int id;
    private String name;
    private String grade;
    private double salary;

    Worker(int id,String name,String grade,double salary){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public double getSalary() {
        return salary;
    }
}
