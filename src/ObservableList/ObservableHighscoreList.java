package ObservableList;

import java.util.*;

public class ObservableHighscoreList extends ObservableList {
    private int maxSize;
    private List<ObservableListListener> listeners = new ArrayList<>();

    public ObservableHighscoreList(int maxSize) {
        this.maxSize = maxSize;
        super.c = Integer.class;
    }

    public void addResult(int result) {
        addElement(result);
        elements.sort(null);
        elements = elements.subList(0, elements.size() > maxSize ? maxSize:elements.size());
        int index = elements.lastIndexOf(result);
        listeners.forEach(n -> n.listChanged(this, index));
    }

    public void addObservableListListener(ObservableListListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    public void removeObservableListListener(ObservableListListener listener) {
        this.listeners.remove(listener);
    }

    public int size() {
        return elements.size();
    }


    @Override
    public String toString() {
        String r = "";
        for (Object n : elements) {
            r += n+"\n";
        }
        return r;

    }
}
