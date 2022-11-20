package compscia.Controller;
import compscia.QuizQuestion;
import compscia.word.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
public class FlashCardsWindowController implements Initializable {
    public Button nextButton;
    public TextField swahiliText;
    public TextField englishText;
    public Button revealButton;
    private Word currentWord;
    MakeFlashCards makeFlashCards;
    @FXML
    AnchorPane flashCardWindowPane;
    //multiple ActionEvents to make the flashcards
    public void reveal(ActionEvent actionEvent) {
        englishText.setText(currentWord.getEnglishMeaning());
    }
    public void next(ActionEvent actionEvent) {
        int count=0;

        if(count<MainWindowController.getDictionary().getDictionaryStorageByEnglishKey().size()) {
            clearFields();
            QuizQuestion flashQuestion = new
                    QuizQuestion(MainWindowController.getDictionary());
            currentWord = flashQuestion.getQuestionWordWord();
            swahiliText.setText(currentWord.getswahiliMeaning());
            count++;
        }
    }
    public void clearFields(){
        englishText.setText("");
        swahiliText.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flashCardWindowPane.setStyle("-fx-background-color: #F5F5DC");
        QuizQuestion flashQuestion = new
                QuizQuestion(MainWindowController.getDictionary());
        currentWord = flashQuestion.getQuestionWordWord();
        swahiliText.setText(currentWord.getswahiliMeaning());
    }
}