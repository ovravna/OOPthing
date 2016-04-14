package Person;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name,email, SNN;
    private Date birthday;
    private char gender;
    private static ArrayList<String> areaCodes;

    public Person() {
        areaCodes = getAreaCodeArray();
    }

    public void setDateOfBirthday(int[] date) {
        try {
            setDateOfBirthday(date[0],date[1],date[2]);
        } catch (Exception e) {
            System.err.println("Invalid array");
        }
    }
    public void setDateOfBirthday(int d, int m, int y) {
        Date date = new Date();
        date.setDate(d);
        date.setMonth(m-1);
        if (y < 16) y += 100;
        date.setYear(y);
        setBirthday(date);
    }

    private boolean validate(String mailDomain) throws Exception {
        Pattern domainPattern = Pattern.compile("(?<=<td>)([A-Z]{2})|([A-Z]{3})(?=</td>)");
        URL url = new URL("https://countrycode.org/");
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            Matcher match = domainPattern.matcher(scanner.nextLine());
            while (match.find()) {
                if (mailDomain.equalsIgnoreCase(match.group())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validateAreaCode(String mailDomain) throws Exception {
        for (String s : areaCodes) {
            if (s.equalsIgnoreCase(mailDomain)) {
                return true;
            }
        }
        return false;
    }



    private ArrayList getAreaCodeArray() {
        ArrayList<String> areaCodes = new ArrayList<String>();
        Pattern domainPattern = Pattern.compile("(?<=<td>)([A-Z]{2})|([A-Z]{3})(?=</td>)");
        Scanner scanner = null;
        try {
            URL url = new URL("https://countrycode.org/");
            scanner = new Scanner(url.openStream());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        while (scanner.hasNext()) {
            Matcher match = domainPattern.matcher(scanner.nextLine());
            while (match.find()) {
                areaCodes.add(match.group());
            }
        }
        return areaCodes;
    }



    /* ~~~~~~~~~~~~ Getters & Setters ~~~~~~~~~~~~ */

    public void setName(String name) {
        Pattern namePattern = Pattern.compile("^[A-Za-z]{2,}\\s[A-Za-z]{2,}$");
        Matcher match = namePattern.matcher(name);
        if (match.find()) {
            this.name = name;
        } else {
            String exception = String.format("%s is not a full name, please enter your full name", name);
            throw new IllegalArgumentException(exception);
        }
    }

    public void setEmail(String email) throws IllegalArgumentException {
        Matcher mailMatch = Pattern.compile("^([A-Za-z]{2,})\\.([A-Za-z]{2,})@[0-9A-Za-z]+\\.([A-Za-z]{2,3})$").matcher(email);
        if (mailMatch.find()) {
            try {
                if (validateAreaCode(mailMatch.group(3)) && isValidName(mailMatch.group(1)+" "+ mailMatch.group(2))) {
                    this.email = email;
                } else throw new Exception();
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid Email");
            }
        } else throw new IllegalArgumentException("Invalid Email");
    }

    private boolean isValidName(String s) {
        if (!getName().equals("- -")) {
            return s.equalsIgnoreCase(name);
        } else return true;
    }

    public void setBirthday(Date birthday) {
        Date now = new Date();
        if (birthday.before(now)) {
            this.birthday = birthday;
        } else throw new IllegalArgumentException("Invalid Birthday");
    }

    public void setGender(char gender) {
        if (gender != 'M' && gender != 'F' && gender != '\0') throw new IllegalArgumentException("Invalid Gender");
        this.gender = gender;
    }

    public void setSNN(String SNN) {
        if (birthday == null || gender == '\0' || SNN.length() != 11) {
            throw new IllegalArgumentException(((SNN.length() != 11)?
                    "SNN is not elleven characters. long":"Sufficient information is not given."));
        } else {
            int d1, d2, m1, m2, y1, y2, k1 = 0, k2 = 0;
            int[] f = {3, 7, 6, 1, 8, 9, 4, 5, 2};
            int[] g = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
            int[] personNum = new int[11];
            for (int i = 0;i < SNN.length();i++) {
                personNum[i] = Character.getNumericValue(SNN.charAt(i));
                if (personNum[i] < 0 || personNum[i] > 9) throw new IllegalArgumentException("Non-nummeric SNN.");
            }
            int date = birthday.getDate();
            int month = birthday.getMonth()+1;
            int year = birthday.getYear();
            d1 = Math.floorDiv(date, 10);
            d2 = date%10;
            m1 = Math.floorDiv(month, 10);
            m2 = month%10;
            y1 = (year < 100) ? Math.floorDiv(year, 10):Math.floorDiv(Math.floorDiv(year, 10), 100);
            y2 = year%10;
            int[] birthArray = {d1, d2, m1, m2, y1, y2};
            for (int i = 0;i < birthArray.length;i++) {
                if (personNum[i] != birthArray[i]) {
                    throw new IllegalArgumentException("Fødtselsnummer er feil.");
                }
            }
            if (!((gender == 'M' && personNum[8]%2 == 1) || (gender == 'F' && personNum[8]%2 == 0))) {
                throw new IllegalArgumentException("Personnummert er feil.");
            }
            for (int i = 0;i < 9;i++) {
                k1 += personNum[i]*f[i];
                k2 += personNum[i]*g[i];
            }
            k2 += personNum[9]*g[9];
            k1 = 11-(k1%11);
            k2 = 11-(k2%11);

            if (personNum[9] != k1 || personNum[10] != k2) {
                throw new IllegalArgumentException("Personnummeret er feil.");
            }
            this.SNN = SNN;
        }
    }

    public String getName() {
        return ((name == null)? "- -":name);
    }

    public String getEmail() {
        return ((email == null) ? "-":email);
    }

    public Date getBirthday() {
        return birthday;
    }

    public char getGender() {
        return ((gender == '\0') ? '-':gender);
    }

    public String getSNN() {
        return (SNN == null ? "-":SNN);
    }

    @Override
    public String toString() {
        String returnString = "";
        String[] names = getName().split(" ");
        if (!getName().equals("- -")) returnString = ((gender == 'F') ? "Mrs. ":((gender == 'M') ? "Mr. ":names[0]+" "))+names[1]+"'s bio:\n";
        String returnBirthday = String.format(((birthday == null)? "-":"%1$td.%1$tm.%1$tY"), getBirthday());
        returnString += "Name: %"+(8+getName().length())+"s\nEmail: %"+(7+getEmail().length())+"s\nBirthday: %14s\nGender: %7s\nPersonnummer: %s\n";
        return String.format(returnString, getName(), getEmail(), returnBirthday, getGender(), getSNN());
    }

}

