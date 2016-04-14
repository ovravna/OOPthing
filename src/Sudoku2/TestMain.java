package Sudoku2;

//import java.util.*;

public class TestMain {

    static int[][] kake() {
        return new int[][] {{1,3}, {4,3}, {1,5,3}, {3,7,0,7,6}};

    }


    public static void main(String[] args) {
        for (int i = 0;i < 10;i++) {
            try {
                dildo(i);
                System.out.println(i);

            } catch (Exception e) {
                System.out.println("kake!");
            }
        }




//        new Test().things();


    }

    private static void dildo(int i) throws Exception {
        if (i == 7 || i == 9) {
            throw new Exception();
        }
    }

//    private int placed;
//    private int[][] board;
//    private int[][] boardOverlay;
//    private List<SudokuBoardState> boardState = new ArrayList<>();
//
//
//    private void setSudoku(SudokuBoardState state) {
//        this.board = state.getBoard();
//        this.boardOverlay = state.getBoardOverlay();
//        this.placed = state.getPlaced();
//
//    }
//
//
//     public boolean play() {
//         SudokuBoardState state = new SudokuBoardState(board, boardOverlay, placed);
//         int[] coordinates;
//         try {
//             coordinates = SudokuContent.setPosition();
//         } catch (Undo undo) {
//
//             SudokuBoardState thisState = boardState.get(boardState.size()-1);
//             SudokuBoardState prevState = boardState.get(0);
//
//             this.setSudoku(prevState);
//
//
//             return true;
//
//         } catch (Redo redo) {
////            boardState.add(undos.pop());
////            setSudoku(undos.peek());
//             return true;
//         }
}
