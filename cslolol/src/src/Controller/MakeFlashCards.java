package compscia.Controller;
// add code for MakeFlashCards.java

import java.io.Serializable;
import compscia.*;
import compscia.word.DictionaryStore;
import java.util.ArrayList;
public class MakeFlashCards implements Serializable {
    private int numberOfQuestions;
    private ArrayList<QuizQuestion> flashCardQuestionArrayList;
    private DictionaryStore dictionaryStore;
    public MakeFlashCards(int numberOfQuestions, DictionaryStore
            dictionaryStore) {

        if(dictionaryStore.getDictionaryStorageByEnglishKey().size()>=(numberOfQuestions+1)){
            this.numberOfQuestions = numberOfQuestions+1;
        }
 else {

            this.numberOfQuestions=dictionaryStore.getDictionaryStorageByEnglishKey().size();
        }
        this.dictionaryStore = dictionaryStore;
        this.flashCardQuestionArrayList = new ArrayList<QuizQuestion>();
        //make flash cards if there are at least 4 words in dictionary

        if(this.dictionaryStore.getDictionaryStorageByEnglishKey().size()>=4) {
            this.createFlash();
        }
        else {
            System.out.println("Not Enough Words");
        }
    }
    private void createFlash(){
        int i=0;
        while(i<this.numberOfQuestions){
            QuizQuestion quizQuestion=new
                    QuizQuestion(this.dictionaryStore);
            if(isUniqueQuestion(quizQuestion)){
                this.flashCardQuestionArrayList.add(quizQuestion);
                i++;
            }
        }
        }

    //makes sure all questions are unique
    private boolean isUniqueQuestion(QuizQuestion quizQuestion){
        for(int i = 0; i<this.flashCardQuestionArrayList.size(); i++){

            if(this.flashCardQuestionArrayList.get(i).getQuestionWord().equals(quizQuestion.getQuestionWord())){return false;
            }
        }
        return true;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public ArrayList<QuizQuestion> getFlashCardQuestionArrayList() {
        return flashCardQuestionArrayList;
    }
}
