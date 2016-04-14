package Office;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
    Map<Employee, List<String>> printHistory = new HashMap<>();

    void printDocument(String document, Employee employee) {
        printHistory.put(employee, printHistory.containsKey(employee) ?
                printHistory.get(employee).add(document) ? printHistory.get(employee):null:Lists.newArrayList(document));

    }

    List<String> getPrintHistory(Employee employee) {
        return printHistory.getOrDefault(employee, new ArrayList<>());
    }
}


// condition ? (else) code : (then) code


// code if condition else code


