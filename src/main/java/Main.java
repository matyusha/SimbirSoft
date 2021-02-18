import DB.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите адрес страницы: ");
            String url = scanner.nextLine();
            scanner.close();

            String fileName = FileWorker.generateFileNameFromUrl(url);
            System.out.println(fileName);

            FileWorker fileWorker = new FileWorker(fileName);
            fileWorker.savePage(url);
            System.out.println("HTML страница сохранена в файле " + fileName + "\n");

            HTMLParser htmlParser = new HTMLParser();
            HashMap<String, Integer> map = htmlParser.getWordStatistic(htmlParser.getTextFromHTML(fileName));

            System.out.println("Статистика по количеству уникальных слов:");
            StatisticCRUD statisticCRUD = new StatisticCRUD();
            for (String s :
                    map.keySet()) {
                System.out.println(s + " " + map.get(s));
                statisticCRUD.save(new Statistic(s, map.get(s), url));
            }
            System.out.println(map.size());
        } catch (IOException e) {
            log.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
        } catch (Exception e) {
            log.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }
}
