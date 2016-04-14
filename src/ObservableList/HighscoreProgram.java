package ObservableList;

import java.util.*;

public class HighscoreProgram implements ObservableListListener {
    private ObservableHighscoreList list;
    private Scanner input = new Scanner(System.in);

    public HighscoreProgram(int n) {
        this.list = new ObservableHighscoreList(n);
    }

    public static void main(String[] args) {
        new HighscoreProgram(3).run();
    }

    private void run() {
        list.addObservableListListener(this);

        while (true) {
            list.addResult(input.nextInt());
        }


    }

    @Override
    public void listChanged(ObservableList list, int index) {
        System.out.println(list);
        System.out.println("Changed at "+index);

    }
}
