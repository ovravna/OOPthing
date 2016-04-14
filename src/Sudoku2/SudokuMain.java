package Sudoku2;

public class SudokuMain {
    private static Sudoku sudoku = new Sudoku();

    public static void main(String[] args) {
        while (sudoku.show()){
            sudoku = sudoku.play();
        }
    }
}