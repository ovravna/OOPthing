package Searcher;

public class SearchMain {
    public static void main(String[] args) {
        Text text = new Text("Hei dette er en text! Det er kult!");
        Text text1 = new Text();
        text1.find("det");
        System.out.println(text);
    }
}
