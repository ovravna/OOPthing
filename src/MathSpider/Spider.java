package MathSpider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider {
    private String html;
    private String generalPicureUrl = "https://html2-f.scribdassets.com/2pdsh00a4g2a1yj1/images/%s.jpg";
    private String filePath;


    public static void main(String[] args) {
        Spider spider = new Spider("/media/olevra/Windows/Users/Ole/IdeaProjects/OOBøving/src/MathSpider/Pictures/");
        try {
            spider.savePictures();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Spider(String filePath) {

        this.html = getHtml();
        this.filePath = filePath+"%s";

    }


    private String getHtml(){
        Scanner scanner = null;
        String returnString = "";

        try {
            URL url = new URL("");
            scanner = new Scanner(url.openStream());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        while (scanner.hasNext()) {
            returnString += scanner.nextLine();
        }
        System.out.println(returnString);
        return returnString;
    }



    private ArrayList getPageCodeArray() {
        ArrayList<String> pageCodes = new ArrayList<String>();
        Pattern codePattern = Pattern.compile("(?<=pages/).{10,18}(?=\\.json)");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(html));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        while (scanner.hasNext()) {
            String kake = scanner.nextLine();
            Matcher match = codePattern.matcher(kake);
            while (match.find()) {
                pageCodes.add(match.group());
            }
        }


        return pageCodes;
    }

    void savePictures() throws IOException {
        ArrayList<String> pageCodes = getPageCodeArray();
        Pattern numPattern = Pattern.compile("\\d+(?=-)");
        String savePath, pictureUrl, pictureNum;
        Matcher matcher;


        for (int i = 0;i < pageCodes.size();i++) {
            matcher = numPattern.matcher(pageCodes.get(i));
            if (matcher.find()) pictureNum = matcher.group();
            else pictureNum = "fail-"+i;

            savePath = String.format(filePath, "Side-"+pictureNum+".jpg");

            try {
                pictureUrl = String.format(generalPicureUrl, pageCodes.get(i));
                InputStream in = new URL(pictureUrl).openStream();
                Files.copy(in, Paths.get(savePath));
            } catch (Exception e) {
            }

            if (i == 8) break;
        }

    }


}
