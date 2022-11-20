package compscia.word;
import java.io.Serializable;
public class Word implements Serializable {
    private String englishMeaning;
    private String englishWordType;
    private String englishAdditionalNotes;
    private String swahiliMeaning;
    private String swahiliWordType;
    private String swahiliAdditionalNotes;
    //saves the words
    public Word(String englishWord, String englishWordType, String
            englishAdditionalNotes, String swahiliMeaning, String swahiliWordType,
                String swahiliAdditionalNotes) {
        this.englishMeaning = englishWord;
        this.englishWordType = englishWordType;
        this.englishAdditionalNotes = englishAdditionalNotes;
        this.swahiliMeaning = swahiliMeaning;
        this.swahiliWordType = swahiliWordType;
        this.swahiliAdditionalNotes = swahiliAdditionalNotes;
    }
    public String getEnglishMeaning() {
        return englishMeaning;
    }
    public String getEnglishWordType() {
        return englishWordType;
    }
    public String getEnglishAdditionalNotes() {
        return englishAdditionalNotes;
    }
    public String getswahiliMeaning() {
        return swahiliMeaning;
    }
    public String getswahiliWordType() {
        return swahiliWordType;
    }
    public String getswahiliAdditionalNotes() {
        return swahiliAdditionalNotes;
    }
    @Override
    public String toString() {
        return "Word{" +
                "english='" + englishMeaning + '\'' +
                ", swahili='" + swahiliMeaning + '\'' +
                '}';
    }
}
