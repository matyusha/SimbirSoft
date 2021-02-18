package DB;

import javax.persistence.*;

@Entity
@Table(schema = "public", name="statistic")
public class Statistic {

    @Id
    @Column(name = "word")
    private String word;

    @Column(name = "frequency")
    private int frequency;

    @Column(name = "url")
    private String url;

    public Statistic(){}

    public Statistic(String word, int frequency, String url) {
        this.word = word;
        this.frequency = frequency;
        this.url = url;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
