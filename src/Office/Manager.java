package Office;

import java.util.*;
import java.util.function.BinaryOperator;

public class Manager implements Employee{
    private List<Employee> employees;
    private Random ran = new Random();
    int taskCount = 0;



    public Manager(Collection<Employee> employees) throws IllegalArgumentException {
        if (employees.isEmpty()) throw new IllegalArgumentException("Durp!");
        this.employees = (List<Employee>) employees;
    }

    @Override
    public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
        taskCount++;
        return getRandomEmployee().doCalculations(operation, value1, value2);
    }

    @Override
    public void printDocument(String document) {
        taskCount++;
        getRandomEmployee().printDocument(document);
    }

    @Override
    public int getTaskCount() {
        return taskCount;
    }

    @Override
    public int getResourceCount() {
        Integer resourceCount = employees.stream().mapToInt(Employee::getResourceCount).sum();
        return resourceCount + 1;
    }

    private Employee getRandomEmployee() {
        return employees.get(ran.nextInt(employees.size()));
    }
}
