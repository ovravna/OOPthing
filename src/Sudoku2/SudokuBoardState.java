package Sudoku2;


public class SudokuBoardState implements java.io.Serializable{

    private int[][] board;
    private int[][] boardOverlay;
    private int placed;

    public SudokuBoardState(int[][] board, int[][] boardOverlay, int placed) {
        this.board = copy(board);
        this.boardOverlay = copy(boardOverlay);
        this.placed = placed;
    }


    private static int[][] copy(int[][] list) {
        int n = Sudoku.n;
        int[][] r = new int[n][n];
        for (int i = 0; i<n; i++) {
            for (int j = 0;j < n;j++) {
                r[i][j] = list[i][j];
            }
        }
        return r;

    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getBoardOverlay() {
        return boardOverlay;
    }

    public int getPlaced() {
        return placed;
    }

    @Override
    public String toString() {
        return new Sudoku(this).toString();
    }
}
