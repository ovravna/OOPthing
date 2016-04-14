package Person;

import java.io.File;

/**
 * Created by Ole on 28.01.2016. "https://countrycode.org/"
 */
public class Testin {
    public static void main(String[] args) {
        new File("./Pics").mkdir();
    }

}














//    public static void main(String[] args) throws Exception {
//        String mailDomain = "se";
//        Pattern domainPattern = Pattern.compile("(?<=<td>)([A-Z]{2})|([A-Z]{3})(?=</td>)");
//        URL url = new URL("https://countrycode.org/");
//        Scanner scanner = new Scanner(url.openStream());
//        while (scanner.hasNext()) {
//            Matcher match = domainPattern.matcher(scanner.nextLine());
//            while (match.find()) {
//                System.out.println(match.group());
//                if (mailDomain.equalsIgnoreCase(match.group())) {
//                    System.out.println(match.group());
//                }
//            }
//        }









//        String mailDomain = "se";
//
//        Pattern domainPattern = Pattern.compile("(?<=<td>)(([A-Z]{2})|[A-Z]{3})(?=</td>)");
//        URL url = new URL("https://countrycode.org/");
//        Scanner scanner = new Scanner(url.openStream());
////        String urlText = "";
//        while (scanner.hasNext()) {
//            Matcher match = domainPattern.matcher(scanner.nextLine());
//            while (match.find()) {
//                System.out.println(match.group());
//                if (mailDomain.equalsIgnoreCase(match.group())) {
//                    System.out.println(match.group());
////                validDomain = true;
//                }
//
//            }
////        Matcher match = domainPattern.matcher(urlText);
//            while (match.find()) {
//                if (mailDomain.equalsIgnoreCase(match.group())) {
////                validDomain = true;
//                }
//            }


