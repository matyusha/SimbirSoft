import org.jsoup.Jsoup;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HTMLParser {

    public String getTextFromHTML(String fileName) throws IOException {
        BufferedReader br = null;
        String str;
        StringBuilder result = new StringBuilder();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
            while ((str = br.readLine()) != null) {
                result.append(str);
            }
        }
        finally {
            if(br !=null){
                br.close();
            }
        }
        return Jsoup.parse(result.toString()).text();
    }

    public HashMap<String, Integer> getWordStatistic(String str) {
        HashMap<String, Integer> stat = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(str, " \"[]()\t\n\r,.?!;:");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (stat.containsKey(token)) {
                stat.put(token, stat.get(token) + 1);
            } else {
                stat.put(token, 1);
            }
        }
        return  stat;
    }
}
