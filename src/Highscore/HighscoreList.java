package Highscore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HighscoreList implements Iterator {
    private List<Integer> highscores = new ArrayList<>();
    private List<HighscoreListListener> listeners = new ArrayList<>();
    private int maxSize;
    private int index = 0;

    public HighscoreList(int maxSize, HighscoreListListener... listeners) {
        this.maxSize = maxSize;
        for (HighscoreListListener listener : listeners) {
            this.listeners.add(listener);
        }
    }

    public HighscoreList(int maxSize) {
        this.maxSize = maxSize;
    }

    public int size() {
        return highscores.size();
    }

    public int getElement(int i) {
        return highscores.get(i);
    }

    public void removeHighscoreListListener(HighscoreListListener listener) {
        this.listeners.remove(listener);
    }

    public void addHighscoreListListener(HighscoreListListener listener) {
        this.listeners.add(listener);
    }


    public void addResult(int result) {
        highscores.add(result);
//        highscores.sort(null);
        if (highscores.size() > maxSize) highscores = highscores.subList(0, maxSize);
//        System.out.println(highscores);
//        int index = highscores.lastIndexOf(result);

//        listeners.forEach(n -> n.listChanged(this, index));


        sendToListeners(result);
    }

    private void sendToListeners(int result) {


        int index = highscores.lastIndexOf(result);


        for (int i = 0;i < listeners.size();i++) {
            long t0 = System.nanoTime();
            listeners.get(i).listChanged(this, index);
        }
    }

    @Override
    public String toString() {
        String r = "";

        for (int n : highscores) {
            r += n+"\n";
        }
        return r;
    }

    @Override
    public boolean hasNext() {
        return index < highscores.size();
    }

    @Override
    public Object next() {
        int n = highscores.get(index);
        index++;
        return n;
    }
}
