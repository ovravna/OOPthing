package SuDoKu;

public class SudokuMain {
    private static Sudoku sudoku = new Sudoku();


    public static void main(String[] args) {
        long num = 1_000_000_000;

        long t0 = System.nanoTime();
        for (int i = 0;i < num;i++) {
            System.out.printf("",(int)Math.pow(-1, i));
        }

        System.out.println(System.nanoTime()-t0);
        System.out.println();
        long t1 = System.nanoTime();
        for (int i = 0;i < num;i++) {
            System.out.printf("", i%2 == 0 ? 1:-1);
        }
        System.out.println(System.nanoTime()-t1);

    }

//    public static void main(String[] args) {
//        while (sudoku.show()) try {
//            sudoku = sudoku.play();
//        } catch (Load load) {
//            Sudoku s = Sudoku.load();
//            sudoku = s == null ? sudoku:s;
//        } catch (Save save) {
//            Sudoku.save(sudoku);
//        } catch (Done done) {
//            if (done.isWon()) System.out.println("You won!");
//            else {
//                Sudoku.save(sudoku);
//                System.err.println("Game saved...");
//            }
//            break;
//        }
//    }
}
