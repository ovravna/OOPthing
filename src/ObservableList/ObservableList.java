package ObservableList;

//import java.util.*;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
    protected List elements = new ArrayList();
    protected Class c;

    public Object getElement(int i) {
        return elements.get(i);
    }

    public boolean acceptsElement(Object o) {
        return o.getClass().equals(c);
    }

    public void addElement(Object element) {
        if (this.acceptsElement(element)) elements.add(element);
    }

    public void addElement(int index, Object element) {
        if (this.acceptsElement(element) && index < elements.size()) {
            elements.add(index, element);
        } else throw new IllegalArgumentException();

    }

    public void removeElement(int index) {
        elements.remove(index);
    }





}
