package Sudoku2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    List<Integer> states = new ArrayList<>();
    List<Integer> undoneStates = new ArrayList<>();


    void things() {
        Scanner input = new Scanner(System.in);
        int kake;
        while (true) {
            kake = input.nextInt();
            states.add(kake);

            if (kake == 3) {
                undoneStates.add(states.remove(states.size()-1));
                kake = states.remove(states.size()-1);
            }
            System.out.println(kake);
        }


    }
    
    
}
