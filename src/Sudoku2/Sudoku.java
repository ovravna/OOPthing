package Sudoku2;

import games.IPersistable;
import games.IUndoable;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sudoku implements Serializable, IUndoable, IPersistable {
    static int n;
    private int placed;
    private int[][] board,boardOverlay;
    private Stack<SudokuBoardState> boardState = new Stack<>();
    private Stack<SudokuBoardState> undos = new Stack<>();
    private static final String SAVE_FILE = "src/SuDoKu/sudokuData.bin";


    public Sudoku() {
        this.n = 9;
        this.board = new int[n][n];
        this.boardOverlay = new int[n][n];
        this.placed = 0;
        this.setNewBoard();
    }

    Sudoku(SudokuBoardState state) {
        this.board = state.getBoard();
        this.boardOverlay = state.getBoardOverlay();
        this.placed = state.getPlaced();
    }

    private void setSudoku(Sudoku that) {
        this.placed = that.getPlaced();
        this.board = that.getBoard();
        this.boardOverlay = that.getBoardOverlay();
        this.boardState = that.getBoardState();
        this.undos = that.getUndos();
    }

    private void setSudoku(SudokuBoardState state) {
        setSudoku(new Sudoku(state));
    }

    private void setNewBoard() {
        Scanner read;
        String boardString = "";

        try {
            read = new Scanner(new File("src/SuDoKu/sudoku"));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return;
        }
        Pattern sudokuPattern = Pattern.compile("(\\d|\\.)*");
        while (read.hasNext()) {
            Matcher matcher = sudokuPattern.matcher(read.nextLine());
            while (matcher.find()) {
                boardString += matcher.group();
            }
        }
        if (boardString.length() < 81) System.err.println("Board not found");

        for (int i = 0;i < 81 && boardString.length() >= 81;i++) {
            if (!Arrays.asList('.', '0').contains(boardString.charAt(i))) {
                board[(int) (i/9.)][i%9] = Integer.parseInt(""+boardString.charAt(i));
                placed++;
            }
        }
        setNewOverlay();

    }


    private void setNewOverlay() {
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (board[i][j] != 0) boardOverlay[i][j] = 2;
            }
        }
    }

    public Sudoku play(){

        try {
            if (playing()) return this;
            else throw new Done(true);
        } catch (IOException e) {
            e.printStackTrace();
            return this;
        } catch (Done done) {
            done.printStackTrace();
            return null;
        }
    }



    public boolean playing() throws Done, IOException{
        if (placed == 81) return !done();


        boardState.add(new SudokuBoardState(board, boardOverlay, placed));

        int[] coordinates;
        try {
            coordinates = SudokuContent.setPosition();
        } catch (Undo undo) {
            undo();
            return true;
        } catch (Redo redo) {
            redo();
            return true;
        } catch (Save save) {
            save(saver(this));
            return true;
        } catch (Load load) {
            load(loader());
            return true;
        }


        if (isEmpty(coordinates)) {
            board[coordinates[0]][coordinates[1]] = SudokuContent.setValue();
            placed++;
        } else if (SudokuContent.isSure(boardOverlay[coordinates[0]][coordinates[1]])) {
            board[coordinates[0]][coordinates[1]] = SudokuContent.setValue();
            setOverlay(coordinates, true);
        } else {
            if (boardOverlay[coordinates[0]][coordinates[1]] == 2) {
                System.err.println("Immutable number");
            }
            playing();
        }
        setOverlay(coordinates, false);

        return !done();
    }

    private boolean done() {
        if (placed != 81) return false;
        else {
            for (int i = 0;i < n;i++) {
                for (int j = 0;j < n;j++) {
                    if (boardOverlay[i][j] == 1) return false;
                }
            }
            return true;
        }
    }

    private void setOverlay(int[] c, boolean deleting) {
        int[] count = new int[10];
        List<Integer> horisontalCheck = new ArrayList<>();
        List<Integer> verticalCheck = new ArrayList<>();
        List<Integer> quadCheck = new ArrayList<>();
        int ant;
        for (int i = 0;i < n;i++) {
            ant = count[board[c[0]][i]];
            if (ant != 0 && board[c[0]][i] != 0) {
                horisontalCheck.add(board[c[0]][i]);
            } else {
                count[board[c[0]][i]]++;
            }
        }
        count = new int[10];
        for (int i = 0;i < n;i++) {
            ant = count[board[i][c[1]]];
            if (ant != 0 && board[i][c[1]] != 0) {
                verticalCheck.add(board[i][c[1]]);
            } else {
                count[board[i][c[1]]]++;
            }
        }
        count = new int[10];
        int quadCor1 = 3*(c[0]/3);
        int quadCor2 = 3*(c[1]/3);

        for (int i = quadCor1;i < quadCor1+3;i++) {
            for (int j = quadCor2;j < quadCor2+3;j++) {
                ant = count[board[i][j]];
                if (ant != 0 && board[i][j] != 0) {
                    quadCheck.add(board[i][j]);
                } else {
                    count[board[i][j]]++;
                }
            }
        }
        if (!deleting) {
            for (int i = 0;i < n;i++) {
                if (horisontalCheck.contains(board[c[0]][i]) && boardOverlay[c[0]][i] != 2) boardOverlay[c[0]][i] = 1;
                if (verticalCheck.contains(board[i][c[1]]) && boardOverlay[i][c[1]] != 2) boardOverlay[i][c[1]] = 1;
            }
            for (int i = quadCor1;i < quadCor1+3;i++) {
                for (int j = quadCor2;j < quadCor2+3;j++) {
                    if (quadCheck.contains(board[i][j]) && boardOverlay[i][j] != 2) boardOverlay[i][j] = 1;
                }
            }
        } else {
            for (int i = 0;i < n;i++) {
                if (!horisontalCheck.contains(board[c[0]][i]) && boardOverlay[c[0]][i] != 2) boardOverlay[c[0]][i] = 0;
                if (!verticalCheck.contains(board[i][c[1]]) && boardOverlay[i][c[1]] != 2) boardOverlay[i][c[1]] = 0;
            }
            for (int i = quadCor1;i < quadCor1+3;i++) {
                for (int j = quadCor2;j < quadCor2+3;j++) {
                    if (!quadCheck.contains(board[i][j]) && boardOverlay[i][j] != 2) boardOverlay[i][j] = 0;
                }
            }
        }
    }


    private boolean isEmpty(int[] c) {
        return board[c[0]][c[1]] == 0;
    }

    boolean show() {
        System.out.println(this);
        return true;
    }

    static String toOverlay(int i) {
        return Arrays.asList(" ", "!", ")").get(i);
    }

    @Override
    public String toString() {
        String returnSTR = "";
        for (int i = 0;i < 20;i++) returnSTR += "\n";
        int num;
        for (int i = 0;i < n;i++) {
            if (i%3 == 0) returnSTR += "\n\n\n";
            for (int j = 0;j < n;j++) {
                num = boardOverlay[i][j];
                returnSTR += (board[i][j] == 0 ? " . ":((num == 2 ? "(":" ")+board[i][j]+toOverlay(num)));
                if (j%3 == 2) returnSTR += "\t";
            }
            returnSTR += "\n";
        }
        return returnSTR;
    }

    @Override
    public boolean canUndo() {
        return !boardState.isEmpty();
    }

    @Override
    public void undo() {
        if (boardState.isEmpty()) {
            System.err.println("Undo unabailable");

        } else {
            undos.push(boardState.pop());
            setSudoku(boardState.pop());
        }

    }

    @Override
    public boolean canRedo() {
        return !undos.isEmpty();
    }


    @Override
    public void redo() {
        if (undos.isEmpty()) {
            System.err.println("Redo unavailable");
        } else {
            boardState.push(undos.peek());
            setSudoku(undos.pop());
        }

    }


    public ObjectInputStream loader() throws IOException {
        return new ObjectInputStream(new FileInputStream(SAVE_FILE));
    }

    @Override
    public void load(InputStream inputStream) throws IOException {
        ObjectInputStream obj = (ObjectInputStream) inputStream;
        try {
            Sudoku sudoku = (Sudoku) obj.readObject();
            setSudoku(sudoku);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public ObjectOutputStream saver(Object o) throws IOException{
        FileOutputStream file = new FileOutputStream(SAVE_FILE);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(o);
        out.close();
        return out;
    }

    @Override
    public void save(OutputStream outputStream) throws IOException {

    }

    public Stack<SudokuBoardState> getUndos() {
        return undos;
    }

    public Stack<SudokuBoardState> getBoardState() {
        return boardState;
    }

    public int[][] getBoardOverlay() {
        return boardOverlay;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getPlaced() {
        return placed;
    }

    public void setPlaced(int placed) {
        this.placed = placed;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setBoardOverlay(int[][] boardOverlay) {
        this.boardOverlay = boardOverlay;
    }

    public void setBoardState(Stack<SudokuBoardState> boardState) {
        this.boardState = boardState;
    }

    public void setUndos(Stack<SudokuBoardState> undos) {
        this.undos = undos;
    }

}




class Done extends Throwable {
    boolean b;
    public Done(boolean b) {
        this.b = b;
    }

    public boolean isWon() {
        return b;
    }
}
