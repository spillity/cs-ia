package compscia.Controller;

import compscia.word.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Optional;

public class InputWordsWindowController implements Initializable {
    public TextField englishMeaningText;
    public TextField englishTypeText1;
    public TextField englishNotesText1;
    public TextField swahiliMeaningText1;
    public TextField swahiliTypeText11;
    public TextField swahiliNotesText11;
    public ComboBox englishTypeSelection;
    public ComboBox swahiliTypeSelection;
    @FXML
    AnchorPane inputWordsWindowPane;
    //implementing the error boxes that show up if mandatory fields have not be; inputted
    @FXML
    public void inputWord(){
        boolean flag=true;
        if(!textAreaNotEmpty(englishMeaningText)){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error Input");
            errorAlert.setContentText("Please Enter English Meaning!");
            errorAlert.showAndWait();
            flag=false;
        }
        else if(englishTypeSelection.getSelectionModel().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error Input");
            errorAlert.setContentText("Please Enter English Word Type!");
            errorAlert.showAndWait();
            flag=false;
        }
        else if(!textAreaNotEmpty(swahiliMeaningText1)){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error Input");
            errorAlert.setContentText("Please Enter swahili Word Meaning!");
            errorAlert.showAndWait();
            flag=false;
        }
        else if(swahiliTypeSelection.getSelectionModel().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error Input");
            errorAlert.setContentText("Please Enter swahili Word Type!");
            errorAlert.showAndWait();
            flag=false;}
        if(flag) {
            //confirmation boxes to add the words to wordList
            Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDialog.setHeaderText("Add To Dictionary");
            confirmDialog.setContentText("Do you want to add this word to dictionary?");

            Optional<ButtonType> result = confirmDialog.showAndWait();
            if(result.get() == ButtonType.OK) {
                String englishMeaning = englishMeaningText.getText();
                String englishWordType =
                        englishTypeSelection.getSelectionModel().getSelectedItem().toString();
                String englishAdditionalNotes =
                        englishNotesText1.getText();
                String swahiliMeaning = swahiliMeaningText1.getText();
                String swahiliWordType =
                        swahiliTypeSelection.getSelectionModel().getSelectedItem().toString();
                String swahiliAdditionalNotes =
                        swahiliNotesText11.getText();
                Word word = new Word(englishMeaning, englishWordType,
                        englishAdditionalNotes, swahiliMeaning, swahiliWordType,
                        swahiliAdditionalNotes);
                //adds inputted word to dictionary

                MainWindowController.getDictionary().getDictionaryStorageByEnglishKey().put
                        (englishMeaning, word);
                Alert informationAlert = new
                        Alert(Alert.AlertType.INFORMATION);
                informationAlert.setHeaderText("Input Words");
                informationAlert.setContentText("Word input successful!");
                informationAlert.showAndWait();
                //clear fields
                englishMeaningText.clear();
                englishTypeSelection.getSelectionModel().clearSelection();
                englishNotesText1.clear();
                swahiliMeaningText1.clear();
                swahiliTypeSelection.getSelectionModel().clearSelection();
                swahiliNotesText11.clear();
            }
        }
    }
    //javaFX combo box
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputWordsWindowPane.setStyle("-fx-background-color: #F5F5DC");

        englishTypeSelection.getItems().setAll("Noun","Adjective","Adverb","Verb"," Other");

                swahiliTypeSelection.getItems().setAll("Noun","Adjective","Adverb","Verb","Other");
    }
    public boolean textAreaNotEmpty(TextField textField){if(textField.getText().trim().isEmpty()){
        return false;
    }
    else {
        return true;
    }
    }
}
