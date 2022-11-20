package compscia.Controller;
import compscia.QuizQuestion;
import java.util.ArrayList;
import compscia.word.DictionaryStore;


public class MakeQuiz {
    private int numberOfQuestions;
    private int marks;
    private ArrayList<QuizQuestion> quizQuestionArrayList;
    private ArrayList<String> userAnswersArrayList;
    private DictionaryStore dictionaryStore;
    public MakeQuiz(int numberOfQuestions, DictionaryStore dictionaryStore)
    {

        if(dictionaryStore.getDictionaryStorageByEnglishKey().size()>=(numberOfQuestions+1)){
            this.numberOfQuestions = numberOfQuestions+1;
        }
        else {

            this.numberOfQuestions=dictionaryStore.getDictionaryStorageByEnglishKey().size();
        }
        this.dictionaryStore = dictionaryStore;
        this.quizQuestionArrayList = new ArrayList<QuizQuestion>();
        this.userAnswersArrayList=new ArrayList<String>();
        this.marks=0;
        //make quiz if there are at least 4 words in dictionary

        if(this.dictionaryStore.getDictionaryStorageByEnglishKey().size()>=4) {
            this.createQuiz();
        }
        else {
            System.out.println("Not Enough Words");
        }
    }
    private void createQuiz(){
        int i=0;
        while(i<this.numberOfQuestions){
            QuizQuestion quizQuestion=new
                    QuizQuestion(this.dictionaryStore);
            if(isUniqueQuestion(quizQuestion)){
                this.quizQuestionArrayList.add(quizQuestion);
                i++;
            }
        }
    }
    //makes sure all questions are unique
    private boolean isUniqueQuestion(QuizQuestion quizQuestion){
        for(int i=0;i<this.quizQuestionArrayList.size();i++){if(this.quizQuestionArrayList.get(i).getQuestionWord().equals(quizQuestion.
                getQuestionWord())){
            return false;
        }
        }
        return true;
    }
    //add user answers to arrayList to evaluate for marks
    public void addAnswer(String userAnswer){
        this.userAnswersArrayList.add(userAnswer);
    }
    //calculate marks
    public int calculateMarks(){
        for(int i=0;i<this.quizQuestionArrayList.size();i++){
            String userAnswer=this.userAnswersArrayList.get(i);

            if(this.quizQuestionArrayList.get(i).isCorrectAnswer(userAnswer)){
                this.marks+=10;
            }
        }
        return this.marks;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public int getMarks() {
        return this.marks;
    }
    public ArrayList<QuizQuestion> getQuizQuestionArrayList() {
        return quizQuestionArrayList;
    }
}
