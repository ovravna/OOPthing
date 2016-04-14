package MathSpider;

//import java.util.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathSpider {
    private String file = "/media/olevra/Windows/Users/Ole/IdeaProjects/OOBøving/src/MathSpider/manual.txt";
    private String picture2 = "https://html2-f.scribdassets.com/2pdsh00a4g2a1yj1/images/%s.jpg";
    private String picture1 = "https://html1-f.scribdassets.com/2pdsh00a4g2a1yj1/images/%s.jpg";




    private ArrayList getPageCodeArray() {
        ArrayList<String> pageCodes = new ArrayList<String>();
        Pattern codePattern = Pattern.compile("(?<=pages/).{10,18}(?=\\.json)");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
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

    void makePageCodeArray() throws IOException {
        ArrayList<String> pageCodes = getPageCodeArray();
        String file= "/media/olevra/Windows/Users/Ole/IdeaProjects/OOBøving/src/MathSpider/pageCodes.txt";
        FileWriter fw = new FileWriter(file, true);
        fw.write("{");
        for (int i = 0;i < pageCodes.size();i++) {
            fw.write("\""+pageCodes.get(i)+"\", ");
            if (i%30==29) fw.write("\n");
        }
        fw.write("}");
        fw.close();



    }



    private String[] getPictureUrls() {
        ArrayList<String> pageCodes = getPageCodeArray();
        String[] pictureUrls = new String[pageCodes.size()];
        for (int i = 0;i < pictureUrls.length;i++) {
            pictureUrls[i] = String.format(picture1, pageCodes.get(i));
        }
        return pictureUrls;
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

            savePath =  String.format("/media/olevra/Windows/Users/Ole/IdeaProjects/OOBøving/src/MathSpider/Pictures/%s", "Side-"+pictureNum+".jpg");

            try {
                pictureUrl = String.format(picture2, pageCodes.get(i));
                InputStream in = new URL(pictureUrl).openStream();
                Files.copy(in, Paths.get(savePath));
            } catch (Exception e) {
            }
        }

    }


    void run() {
    String[] pictureUrls = getPictureUrls();
        for (int i = 0;i < pictureUrls.length;i++) {
            System.out.println(pictureUrls[i]);
        }
    }
}
