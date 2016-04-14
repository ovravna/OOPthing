package Test5;

public class LineEditor {
    String text;
    int insertionIndex = 0;

    void left() {
        left(1);
    }
    //Overload
    void left(int n) {
        if (insertionIndex-n >= 0) {
            insertionIndex -= n;
        } else insertionIndex = 0;
    }

    void right() {
        right(1);
    }
    //Overload
    void right(int n) {
        if (insertionIndex + n <= text.length()) {
            insertionIndex += n;
        } else insertionIndex = text.length();
    }

    void insertString(String s) {
        int i,j;
        char[] charList = new char[s.length()+text.length()];
        for (i = 0;i < insertionIndex;i++) {
            charList[i] = text.charAt(i);
        }
        for (j = i;j < i+s.length();j++) {
            charList[j] = s.charAt(j-i);
        }
        for (int k = j;k < charList.length;k++) {
            charList[k] = text.charAt(k-s.length());
        }
        text = "";
        for (char c : charList) {
            text += c;
        }
        right(s.length());
    }

    void deleteLeft() {
        delete(insertionIndex - 1);
        insertionIndex--;
    }

    void deleteRight() {
        delete(insertionIndex);
    }

    void delete(int index) {
        char[] charList = new char[text.length()];
        for (int k = 0;k < charList.length;k++) {
            charList[k] = text.charAt(k);
        }
        for (int i = 0;i < charList.length;i++) {
            if (i<=index) continue;
            charList[i-1] = charList[i];
        }
        String tempText = "";
        for (int j = 0;j < charList.length-1;j++) {
            tempText += charList[j];
        }
        text = tempText;
    }

    void insert(Object o) {
        String t = ""+ o.hashCode();
        insertString(t);
    }

    String mark(int n) {
        return mark(insertionIndex, n);
    }
    //Overload
    String mark(int n, int m) {
        String returnString = "";
        char[] charList = new char[n + m];

        for (int k = 0;k < charList.length;k++) {
            charList[k] = text.charAt(k);
        }
        for (int j = n;j < n+m;j++) {
            returnString += charList[j];
        }
        return returnString;
    }

    @Override
    public String toString() {

        String temp1 = text, temp2;
        insertString("|");
        temp2 = text;
        text = temp1;
        return temp2;
    }
}