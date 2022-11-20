package compscia.Model;

import compscia.Controller.MainWindowController;
import compscia.Controller.viewAllWordsController;
import compscia.QuizQuestion;
import compscia.word.Word;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class ExportWords implements Serializable {
    static OutputStream os;
    public static void writeToCSV() throws IOException {
        ArrayList<String>
                keyWordsArrayList= QuizQuestion.readAllKeys(MainWindowController.getDictionary());
        Collections.sort(keyWordsArrayList);
        PrintWriter pw = null;
        try {
            os = new FileOutputStream("AllWords.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String columnNamesList = "English Meaning,English Word Type,English Notes,swahili Meaning,swahili Word Type,swahili Notes";
        builder.append(columnNamesList +"\n");
        viewAllWordsController viewAllWordsController1=new viewAllWordsController();

        for ( int i=0;i<keyWordsArrayList.size();i++) {
            Word currentWord=MainWindowController.getDictionary().getDictionaryStorageByEnglishKey().get(keyWordsArrayList.get(i));
            builder.append(currentWord.getEnglishMeaning()+",");
            builder.append(currentWord.getEnglishWordType()+",");
            builder.append(currentWord.getEnglishAdditionalNotes()+",");
            builder.append(currentWord.getswahiliMeaning()+",");
            builder.append(currentWord.getswahiliWordType()+",");
            builder.append(currentWord.getswahiliAdditionalNotes());
            builder.append('\n');
        }
// pw.write(builder.toString());

        os.write(builder.toString().getBytes(StandardCharsets.UTF_8));
// pw.close();
        System.out.println("done!");
    }
}