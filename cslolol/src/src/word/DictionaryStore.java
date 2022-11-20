package compscia.word;

import compscia.word.*;
import java.io.Serializable;
import java.util.HashMap;


public class DictionaryStore implements Serializable {
    private final HashMap<String,Word> dictionaryStorageByEnglishKey;
    public DictionaryStore() {
        this.dictionaryStorageByEnglishKey = new HashMap<String,Word>();
    }
    public HashMap<String, Word> getDictionaryStorageByEnglishKey() {
        return dictionaryStorageByEnglishKey;
    }
    public Word getByEnglishWord(String englishWordToSearch){
        return this.dictionaryStorageByEnglishKey.get(englishWordToSearch);
    }
}
