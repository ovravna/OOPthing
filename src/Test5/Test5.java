package Test5;

public class Test5 {
    public static void main(String[] args) {
        LineEditor line = new LineEditor();
        line.text = "Hei dette er tekst.";
        line.right(7);

        line.insertString(" hei");
        line.deleteLeft();
        line.deleteRight();
//        line.
//        String thing = line.mark(3);
//        System.out.println(thing);

        System.out.println(line);
    }
}
