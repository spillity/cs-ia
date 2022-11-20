package compscia.Controller;

import compscia.Controller.MainWindowController;
import compscia.QuizQuestion;
import compscia.word.Word;
import compscia.word.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
public class viewAllWordsController implements Initializable {
    public ScrollPane scrollPane;
    public TableColumn englishMeaningTab;
    public TableColumn englishTypeTab;
    public TableColumn englishNotesTab;
    public TableColumn swahiliMeaningTab;
    public TableColumn swahiliTypeTab;
    public TableColumn swahiliNotesTab;
    public TableView tabelView; //this is spelt wrong on purpose (as naming it tableView; will return an error;)
    private ArrayList<String> elementListInListView;
    @FXML
    Button viewSelected;
    @FXML
    AnchorPane viewAllWordsPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Word> wordArrayList=updateTable();
        viewAllWordsPane.setStyle("-fx-background-color: #F5F5DC");
        ObservableList<Word> data =
                FXCollections.observableArrayList(wordArrayList);
        englishMeaningTab.setCellValueFactory(new
                PropertyValueFactory<Word,String>("englishMeaning"));
        englishTypeTab.setCellValueFactory(new
                PropertyValueFactory<Word,String>("englishWordType"));englishNotesTab.setCellValueFactory(new
                PropertyValueFactory<Word,String>("englishAdditionalNotes"));
        swahiliMeaningTab.setCellValueFactory(new
                PropertyValueFactory<Word,String>("swahiliMeaning"));
        swahiliTypeTab.setCellValueFactory(new
                PropertyValueFactory<Word,String>("swahiliWordType"));
        swahiliNotesTab.setCellValueFactory(new
                PropertyValueFactory<Word,String>("swahiliAdditionalNotes"));
        tabelView.setItems(data);
    }
    public ArrayList<Word> updateTable(){
        ArrayList<Word> wordArrayListTemp=new ArrayList<Word>();
        //get hash map keys arrayList
        ArrayList<String> keysArrayList;
        keysArrayList=
                QuizQuestion.readAllKeys(MainWindowController.getDictionary());
        //sort by alphabetically
        Collections.sort(keysArrayList);
        this.elementListInListView=new ArrayList<String>();
        //update to list view
        for(int i=0;i<keysArrayList.size();i++){
            Word word= MainWindowController.getDictionary().getDictionaryStorageByEnglishKey(
            ).get(keysArrayList.get(i));
            wordArrayListTemp.add(word);
        }
        return wordArrayListTemp;
    }
}