package Searcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;
import java.util.*;

public class Text {
    String text = "", pattern, returnText, findText;
    Pattern pat;

    public Text() {
        try {
            Scanner file = new Scanner(new File(""+
                    "C:\\Users\\Ole\\IdeaProjects\\" +
                    "OOBøving\\src\\Searcher\\SearchString.txt"));
            this.findText = file.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Text(String s) {
        this.findText = s;
    }

    public void find(String patternIN) {
        pattern = String.format("(?i)(\\w*%s\\w*)", patternIN);
        pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(findText);
        int ant = 0;
        while (match.find()) {
            System.out.println(match.group());
            ant++;
        }
        if (ant == 0) {
            System.out.println("No match for search string.");
        }
    }


    public void search(String text) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type search word: ");
        String in = input.next();
        pattern = String.format("(?i)(\\w*%s\\w*)", in);
        pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(text);
        int ant = 0;
        while (match.find()) {
            System.out.println(match.group());
            ant++;
        }
        if (ant == 0) {
            System.out.println("No match for search string.");
        }
    }

    //Overload
    public void search() {
        search(this.text);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        if (findText.length() != 0) {
            return findText;
        }
        return text;
    }
}
