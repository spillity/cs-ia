package compscia.Controller;

import compscia.QuizQuestion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import compscia.*;

public class MakeQuizWindowController implements Initializable {
    public AnchorPane makeQuizGUIPane;
    public Button nextQuestion;
    public Button previousQuestion;
    public RadioButton answerA;
    public RadioButton answerB;
    public RadioButton answerC;
    public RadioButton answerD;
    public Button back;
    public TextArea questionWord;
    public Label marksLabel;
    private int questionNumber;
    private MakeQuiz makeQuiz;
    int clickCount=0;
    @FXML
    public void previous() {
    }
    public void clearFields(){
        questionWord.setText("");
        answerA.isSelected();
        answerB.setText("");
        answerC.setText("");
        answerD.setText("");
        answerA.setSelected(false);
        answerB.setSelected(false);
        answerC.setSelected(false);
        answerD.setSelected(false);
    }
    @FXML
    public void next(){
        if (clickCount<makeQuiz.getNumberOfQuestions()) {
            clickCount++;
            if (answerA.isSelected() && !answerB.isSelected()
                    && !answerC.isSelected() && !answerD.isSelected()) {
                makeQuiz.addAnswer(answerA.getText());
            } else if (!answerA.isSelected() && answerB.isSelected()
                    && !answerC.isSelected() && !answerD.isSelected()) {
                makeQuiz.addAnswer(answerB.getText());
            } else if (!answerA.isSelected() && !answerB.isSelected() &&
                    answerC.isSelected() && !answerD.isSelected()) {
                makeQuiz.addAnswer(answerC.getText());
            } else if (!answerA.isSelected() && !answerB.isSelected()
                    && !answerC.isSelected() && answerD.isSelected()) {
                makeQuiz.addAnswer(answerD.getText());
            } else {
                makeQuiz.addAnswer("N/A");
            }
            clearFields(); //clear all fields
            if (makeQuiz.getNumberOfQuestions() > this.questionNumber) {
                QuizQuestion quizQuestion =
                        makeQuiz.getQuizQuestionArrayList().get(questionNumber);
                questionWord.setText(quizQuestion.getQuestionWord());
                answerA.setText(quizQuestion.getAnswerA());
                answerB.setText(quizQuestion.getAnswerB());
                answerC.setText(quizQuestion.getAnswerC());
                answerD.setText(quizQuestion.getAnswerD());
                this.questionNumber++;
                if (makeQuiz.getNumberOfQuestions() == questionNumber) {
                    nextQuestion.setText("Complete & Evaluate");
                }
            }
            if (clickCount == questionNumber) {
                nextQuestion.setText("Thank You!");
                makeQuiz.calculateMarks();
                marksLabel.setText("Your Marks: " + makeQuiz.getMarks() +" / " +questionNumber*10);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        makeQuizGUIPane.setStyle("-fx-background-color: #F5F5DC");
        nextQuestion.setText("Submit Answer & Continue");
        makeQuiz=new MakeQuiz(6,MainWindowController.getDictionary());
        this.questionNumber=0;
        QuizQuestion quizQuestion =
                makeQuiz.getQuizQuestionArrayList().get(questionNumber);
        questionWord.setText(quizQuestion.getQuestionWord());
        answerA.setText(quizQuestion.getAnswerA());
        answerB.setText(quizQuestion.getAnswerB());answerC.setText(quizQuestion.getAnswerC());
        answerD.setText(quizQuestion.getAnswerD());
        this.questionNumber++;
    }
}