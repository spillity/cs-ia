package compscia;
import compscia.word.Word;
import compscia.word.DictionaryStore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class QuizQuestion implements Serializable {
    private String QuestionWord;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctAnswer;
    private DictionaryStore dictionaryStore;
    private int noOfAllWordsAvailable;
    private int randomNo1,randomNo2,randomNo3,randomNo4;
    private String randomKey1,randomKey2,randomKey3,randomKey4;
    private Random rand=new Random();
    private ArrayList<String> keysArrayList;
    private ArrayList<String> answersArrayList;
    private Word questionWordWord;
    public QuizQuestion(DictionaryStore dictionaryStore) {
        this.dictionaryStore = dictionaryStore;
        this.noOfAllWordsAvailable=
                dictionaryStore.getDictionaryStorageByEnglishKey().size();
        this.keysArrayList=new ArrayList<String>();
        this.answersArrayList=new ArrayList<String>();
        this.generateRandomNumbers();
        this.keysArrayList=readAllKeys(this.dictionaryStore);
        this.assignRandomKeys();
        this.createQuestion();
    }
    //generates random numbers for the quiz questions
    private void generateRandomNumbers(){
        ArrayList<Integer>
                uniqueRandomNumbers=this.UniqueRandomNumbers(0,noOfAllWordsAvailable-1,4);
        randomNo1 = uniqueRandomNumbers.get(0);
        randomNo2 = uniqueRandomNumbers.get(1);
        randomNo3 = uniqueRandomNumbers.get(2);
        randomNo4 = uniqueRandomNumbers.get(3);
    }
    public static ArrayList<String> readAllKeys(DictionaryStore dictionaryStore){
        ArrayList<String> keyWordsArrayList=new ArrayList<String>();
        for ( String key : dictionaryStore.getDictionaryStorageByEnglishKey().keySet() ) {
            keyWordsArrayList.add(key);
        }
        return keyWordsArrayList;
    }
    //adds all answer choices to an arrayList so they can be randomly arranged
    private void readAllAnswers(){

        this.answersArrayList.add(this.dictionaryStore.getDictionaryStorageByEnglishKey().get(randomKey1).getswahiliMeaning());

        this.answersArrayList.add(this.dictionaryStore.getDictionaryStorageByEnglishKey().get(randomKey2).getswahiliMeaning());

        this.answersArrayList.add(this.dictionaryStore.getDictionaryStorageByEnglishKey().get(randomKey3).getswahiliMeaning());

        this.answersArrayList.add(this.dictionaryStore.getDictionaryStorageByEnglishKey().get(randomKey4).getswahiliMeaning());
    }
    private void assignRandomKeys(){
        this.randomKey1=this.keysArrayList.get(randomNo1);
        this.randomKey2=this.keysArrayList.get(randomNo2);
        this.randomKey3=this.keysArrayList.get(randomNo3);
        this.randomKey4=this.keysArrayList.get(randomNo4);
    }
    private void generateAnswerList(){
        boolean run=true;
        int min =0;
        int max=3;
        ArrayList<Integer>
                uniqueRandomNumbers=this.UniqueRandomNumbers(0,3,4);
        int num1= uniqueRandomNumbers.get(0);
        int num2 = uniqueRandomNumbers.get(1);
        int num3 = uniqueRandomNumbers.get(2);
        int num4 = uniqueRandomNumbers.get(3);
        this.answerA=this.answersArrayList.get(num1);
        this.answerB=this.answersArrayList.get(num2);
        this.answerC=this.answersArrayList.get(num3);
        this.answerD=this.answersArrayList.get(num4);
    }
    public void createQuestion(){
        //randomKey1 = question index

        this.QuestionWord=this.dictionaryStore.getDictionaryStorageByEnglishKey().get(randomKey1).getEnglishMeaning();

        this.questionWordWord=this.dictionaryStore.getDictionaryStorageByEnglishKey
                ().get(randomKey1);

        this.correctAnswer=this.dictionaryStore.getDictionaryStorageByEnglishKey().get(randomKey1).getswahiliMeaning();
        this.readAllAnswers();
        this.generateAnswerList(); //assign random answers including the
//        correct answer for choices A,B,C & D
    }

    //to check the input answer is correct
    public boolean isCorrectAnswer(String selectedAnswer){
        if(selectedAnswer.equals(this.correctAnswer)){
            return true;
        }
        else return false;
    }
    public String getQuestionWord() {
        return QuestionWord;
    }
    public String getAnswerA() {
        return answerA;
    }
    public String getAnswerB() {
        return answerB;
    }
    public String getAnswerC() {
        return answerC;
    }
    public String getAnswerD() {
        return answerD;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public Word getQuestionWordWord() {
        return this.questionWordWord;
    }
    //to get random numbers in a range
    public ArrayList<Integer> UniqueRandomNumbers(int from,int to,int
            noOfNumbers) {
        ArrayList<Integer> uniqueRandomNumbers=new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=from; i<=to; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i=0; i<noOfNumbers; i++) {
            uniqueRandomNumbers.add(list.get(i));
        }
        return uniqueRandomNumbers;
    }
}