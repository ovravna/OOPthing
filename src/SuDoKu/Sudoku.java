package SuDoKu;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sudoku implements ObserableGrid {
    static final int N = 9;
    private int round;
    private int placed;
    private int[][] board,boardOverlay;
    private Stack<SudokuBoardState> boardState = new Stack<>();
    private Stack<SudokuBoardState> undos = new Stack<>();
    private List<GridListener> listeners = new ArrayList<>();
    private static final String SAVE_FILE = "src/SuDoKu/files/sudokuData.bin";


    public Sudoku() {
//        this.N = 9;
        this.board = new int[N][N];
        this.boardOverlay = new int[N][N];
        this.placed = 0;
        this.setNewBoard();
    }

    Sudoku(SudokuBoardState state) {
        this.board = state.getBoard();
        this.boardOverlay = state.getBoardOverlay();
        this.placed = state.getPlaced();
    }

    private void setSudoku(SudokuBoardState state) {
        this.board = state.getBoard();
        this.boardOverlay = state.getBoardOverlay();
        this.placed = state.getPlaced();
    }

    private void setNewBoard() {
        Scanner read;
        String boardString = "";

        try {
            read = new Scanner(new File("src/SuDoKu/files/sudoku"));
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
        for (int i = 0;i < N;i++) {
            for (int j = 0;j < N;j++) {
                if (board[i][j] != 0) boardOverlay[i][j] = 2;
            }
        }
    }

    public Sudoku play() throws Done, Save, Load {

        if (playing()) return this;
        else throw new Done(true);
    }



    public boolean playing() throws Load, Save, Done {
        if (placed == 81) return !done();


        boardState.add(new SudokuBoardState(board, boardOverlay, placed));

        int[] coordinates;
        try {
            coordinates = SudokuContent.setPosition();
        } catch (Undo undo) {
            if (boardState.isEmpty()) {
                System.err.println("Undo unabailable");
            } else {
                undos.push(boardState.pop());
                setSudoku(boardState.pop());
            }
            return true;
        } catch (Redo redo) {
            if (undos.isEmpty()) {
                System.err.println("Redo unavailable");
            } else {
                boardState.push(undos.peek());
                setSudoku(undos.pop());
            }
            return true;
        } catch (Save save) {
            boardState.pop();
            throw new Save();
        }


        if (isEmpty(coordinates)) {
            board[coordinates[0]][coordinates[1]] = SudokuContent.setValue();
            if (SudokuContent.isSure(boardOverlay[coordinates[0]][coordinates[1]])) {
                setOverlay(coordinates, true);
            } else placed++;
        } else {
            if (boardOverlay[coordinates[0]][coordinates[1]] == 2) {
                System.err.println("Immutable number");
            }
            playing();
        }


        setOverlay(coordinates, false);
        round++;
        return !done();
    }



    private boolean done() {
        if (placed != 81) return false;
        else {
            for (int i = 0;i < N;i++) {
                for (int j = 0;j < N;j++) {
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
        for (int i = 0;i < N;i++) {
            ant = count[board[c[0]][i]];
            if (ant != 0 && board[c[0]][i] != 0) {
                horisontalCheck.add(board[c[0]][i]);
            } else {
                count[board[c[0]][i]]++;
            }
        }
        count = new int[10];
        for (int i = 0;i < N;i++) {
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
            for (int i = 0;i < N;i++) {
                if (horisontalCheck.contains(board[c[0]][i]) && boardOverlay[c[0]][i] != 2) boardOverlay[c[0]][i] = 1;
                if (verticalCheck.contains(board[i][c[1]]) && boardOverlay[i][c[1]] != 2) boardOverlay[i][c[1]] = 1;
            }
            for (int i = quadCor1;i < quadCor1+3;i++) {
                for (int j = quadCor2;j < quadCor2+3;j++) {
                    if (quadCheck.contains(board[i][j]) && boardOverlay[i][j] != 2) boardOverlay[i][j] = 1;
                }
            }
        } else {
            for (int i = 0;i < N;i++) {
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


    static Sudoku load() {
        try {
            FileInputStream file = new FileInputStream(SAVE_FILE);
            ObjectInputStream in = new ObjectInputStream(file);
            Object r = in.readObject();
            file.close();
            return (Sudoku) r;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    static void save(Sudoku sudoku) {
        try {
            FileOutputStream file = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(sudoku);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String getOverlay(int i) {
        return Arrays.asList(" ", "!", ")").get(i);
    }


    @Override
    public String toString() {

        String returnSTR = "";
        if (round != 0) for (int i = 0;i < 20;i++) returnSTR += "\n";
        else returnSTR += SudokuContent.INFO;
        int num;
        for (int i = 0;i < N;i++) {
            if (i%3 == 0) returnSTR += "\n\n\n";
            for (int j = 0;j < N;j++) {
                num = boardOverlay[i][j];
                returnSTR += (board[i][j] == 0 ? " . ":((num == 2 ? "(":" ")+board[i][j]+getOverlay(num)));
                if (j%3 == 2) returnSTR += "\t";
            }
            returnSTR += "\n";
        }
        return returnSTR;
    }

    @Override
    public void addGridListener(GridListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeGridListener(GridListener listener) {
        listeners.remove(listener);
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
