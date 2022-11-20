package compscia.Controller;
import compscia.Controller.MainWindowController;

import compscia.word.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
public class SearchWordController implements Initializable {
    public TextField englishMeaningText;
    public TextField swahiliMeaningText1;
    public TextField swahiliTypeText11;
    public TextField swahiliNotesText11;
    @FXML
    AnchorPane searchWordPane;
    @FXML
    public void search() {
        //take user input and search for its swahili word in saved word list
        String searchWord=englishMeaningText.getText();
        Word selectedWord= MainWindowController.getDictionary().getByEnglishWord(searchWord);
        if(selectedWord!=null){
            swahiliMeaningText1.setText(selectedWord.getswahiliMeaning());
            swahiliTypeText11.setText(selectedWord.getswahiliWordType());

            swahiliNotesText11.setText(selectedWord.getswahiliAdditionalNotes());
        }
        else {
            swahiliMeaningText1.setText("Not in Dictionary! ");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchWordPane.setStyle("-fx-background-color: #F5F5DC");
    }
}