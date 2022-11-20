package compscia.Controller;

import compscia.word.DictionaryStore;
import compscia.Model.ExportWords;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
public class MainWindowController implements Initializable {
    private static compscia.word.DictionaryStore dictionary;
    public Button closeButton;
    public Button inputWordsButton1;
    @FXML
    Button viewSavedItemsButton;
    @FXML
    Button inputWordsButton;
    @FXML
    Button exportWordsButton;
    @FXML
    Button flashCardsButton;
    @FXML
    Button makeQuizButton;
    @FXML
    javafx.scene.control.TextField userName;
    @FXML
    AnchorPane mainWindowPane;
    @FXML
 /*
 main window when launching gui, multiple buttons are shown
 error popups and confirmation boxes are also implemented*/
    public void inputWords(){
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("inputWordsGUI.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Input Words");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    public void flashCards(){
        if(getDictionary().getDictionaryStorageByEnglishKey().size()==0){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No Words!");
            errorAlert.setContentText("Please input and save at least 4 Words!");
            errorAlert.showAndWait();
        }
        else if (getDictionary().getDictionaryStorageByEnglishKey().size()
                < 4) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No Enough Words!");
            errorAlert.setContentText("Please input and save at least 4 Words!");
            errorAlert.showAndWait();
        }
        else {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("flashCardsGUI.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Flashcards");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }
    @FXML
    public void viewAllSavedWords(){
        if(getDictionary().getDictionaryStorageByEnglishKey().size()==0){Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No Words!");
            errorAlert.setContentText("Please input and save some words first!");
            errorAlert.showAndWait();
        }
        else {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("viewAllWordsGUI.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("All Words");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }
    @FXML
    public void makeQuiz() {
        if(getDictionary().getDictionaryStorageByEnglishKey().size()==0){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No Words!");
            errorAlert.setContentText("Please input and save at least 4 Words!"); //pre-requisite of 4 words for quiz and flashcard functions
            errorAlert.showAndWait();
        }
        else if (getDictionary().getDictionaryStorageByEnglishKey().size()
                < 4) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No Enough Words!");
            errorAlert.setContentText("Please input and save at least 4 Words!");
            errorAlert.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("makeQuizGUI.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("It's Quiz Time!");
            stage.setScene(new Scene(root1));
            stage.show();
        }}
    @FXML
    public void exportWords() throws IOException {
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setHeaderText("Save All Words");
        confirmDialog.setContentText("Do you want to export all words to CSV?");
                Optional<ButtonType> result = confirmDialog.showAndWait();
        if(result.get() == ButtonType.OK) {
            if (getDictionary().getDictionaryStorageByEnglishKey().size()
                    == 0) {
                Alert errorAlert2 = new Alert(Alert.AlertType.ERROR);
                errorAlert2.setHeaderText("No Words!");
                errorAlert2.setContentText("Please input and save some words first!");
                errorAlert2.showAndWait();
            } else {
                ExportWords.writeToCSV();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainWindowPane.setStyle("-fx-background-color: #F5F5DC");
        //read saved file at program start, if there's no saved file a newDictionaryStore object will be created'
        dictionary = FileHandler.readFromFile();
        if(dictionary==null) {
            dictionary = new DictionaryStore();
        }
    }

    public static DictionaryStore getDictionary() {
        return dictionary;
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        System.out.println("Closed");
        FileHandler.writeFile();

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }


    public void search(ActionEvent actionEvent) {
        if(getDictionary().getDictionaryStorageByEnglishKey().size()==0){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("No Words!");
        errorAlert.setContentText("Please input and save some words first!");
        errorAlert.showAndWait();
    }
    else {
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("searchWordGUI.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Search");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
}