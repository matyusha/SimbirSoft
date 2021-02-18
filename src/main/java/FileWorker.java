import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class FileWorker {

    public static String generateFileNameFromUrl(String url){
        return url.replaceAll("[\\/:.,*?<>|\"]", "");
    }

    private String fileName;

    public FileWorker(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void savePage(final String URL) throws IOException {
        StringBuilder str = new StringBuilder();
        String line = "";
        URL myUrl = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            myUrl = new URL(URL);
            in = new BufferedReader(new InputStreamReader(myUrl.openStream()));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));
            while ((line = in.readLine()) != null) {
                out.write(line + "\n");
                str.append(line).append("\n");
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
