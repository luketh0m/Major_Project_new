package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import java.io.*;
import java.util.*;

public class Quiz extends Application {


public static int score ;
public  static int questionNo;




    public static void generateQuestionsAndAnswers(String Difficulty, String difficultyAnswers) throws FileNotFoundException {
// Generates the questions


        List<String> list = new LinkedList<>();
        File QuestionsE = new File(Difficulty); //Loads question text file

        Scanner scanner = new Scanner(QuestionsE);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        String questions[] = list.toArray(new String[list.size()]); //puts all questions in array


        Random r = new Random(); //

        List<String> listA = new LinkedList<>(); //Create a new list
        File QuestionsA = new File(difficultyAnswers); //Loads question text file

        Scanner scannerA = new Scanner(QuestionsA); //Look at text file with answers on

        while (scannerA.hasNextLine()) { //Add each line of answers to list, new line = new answer
            listA.add(scannerA.nextLine());
        }

        String questionsAnswers[] = listA.toArray(new String[listA.size()]); //puts all answers in array, same order as questions



        displayQuestions(questions, questionsAnswers);
        quizGame(questions, questionsAnswers);

    }

    public static String generateRandomAnswer (String questionAnswers[]) {

            Random r = new Random();
            int numberOfQuestions = questionAnswers.length;
            int random = r.nextInt(numberOfQuestions);

            String randomAnswer = questionAnswers[random];


            return randomAnswer;

    }
   public static String[] displayQuestions (String questions[], String questionsAnswers[]) {


       Random r = new Random();
       int numberOfQuestions = questions.length;
       int random = r.nextInt(numberOfQuestions);

       String qAndA[] = new String [2];
       qAndA [0]  = questions[random];
       qAndA [1] = questionsAnswers[random];



       return qAndA;

    }

    public static void correctAnswerChosen (Stage primaryStage, String questions[], String questionsAnswers[]) {
        if (Quiz.questionNo < 10) {
            Quiz.score++;
            Quiz.questionNo++;
            primaryStage.close();
            quizGame(questions, questionsAnswers);


        }
        else if (Quiz.questionNo  == 10 ) {
            Quiz.score++;
            Quiz.questionNo++;
            primaryStage.close();
            quizOver(primaryStage);

        }
    }

    public static  void incorrectAnswerChosen(Stage primaryStage, String questions[], String questionsAnswers[]) {

        if (Quiz.questionNo < 10) {
            Quiz.questionNo++;
            primaryStage.close();
            quizGame(questions, questionsAnswers);

        } else if (Quiz.questionNo == 10) {

            Quiz.questionNo++;
            primaryStage.close();
            quizOver(primaryStage);
        }


    }
    public static void quizMenu() {

        Quiz quiz = new Quiz();

        quiz.score =0;
        quiz.questionNo = 1;



        // Text files of question and answers
        String Easy = "easyQuestions.txt";
        String Medium = "mediumQuestions.txt";
        String Hard = "hardQuestions.txt";

        String easyAnswer = "easyQuestionsAnswers.txt";
        String mediumAnswer = "mediumQuestionsAnswers.txt";
        String hardAnswer = "hardQuestionsAnswers.txt";

        //Difficulty selection
        Stage primaryStage = new Stage();
        Button easyButton = new Button("Easy");
        Button mediumButton = new Button("Medium");
        Button hardButton = new Button("Hard");
        //Layout for page
        VBox layout = new VBox();
        layout.getChildren().addAll(easyButton, mediumButton, hardButton);


        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


                easyButton.setOnAction(e -> {

                    try {
                        generateQuestionsAndAnswers(Easy, easyAnswer);


                    } catch (FileNotFoundException notFound) {
                        System.out.print(notFound);
            }


        });


        mediumButton.setOnAction(e -> {

            try {
                generateQuestionsAndAnswers(Medium, mediumAnswer);


            } catch (FileNotFoundException notFound) {
                System.out.print(notFound);
            }


        });

        hardButton.setOnAction(e -> {

            try {
                generateQuestionsAndAnswers(Hard, hardAnswer);


            } catch (FileNotFoundException notFound) {
                System.out.print(notFound);
            }


        });

    }

    public static void quizGame (String questions[], String questionsAnswers[]) {


        Stage primaryStage = new Stage();
        String wrongAnswer = Quiz.generateRandomAnswer(questionsAnswers);
        String wrongAnswer2 = Quiz.generateRandomAnswer(questionsAnswers);
        String wrongAnswer3 = Quiz.generateRandomAnswer(questionsAnswers);
        String Question[] = Quiz.displayQuestions(questions, questionsAnswers);

        Label questionNumberLabel = new Label("Question " + Quiz.questionNo + " Out of 10");
        Label questionLabel = new Label(Question[0]); //Display Question on screen
        Button correctAnswer = new Button(Question[1]); //correct answer always on the same button, but button will move
        Button incorrectOne = new Button(wrongAnswer);
        Button incorrectTwo = new Button(wrongAnswer2);
        Button incorrectThree = new Button(wrongAnswer3);


        VBox layout = new VBox();
        layout.getChildren().addAll( questionNumberLabel, questionLabel,correctAnswer,incorrectOne, incorrectTwo, incorrectThree);
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        correctAnswer.setOnAction(e -> {

            correctAnswerChosen(primaryStage, questions, questionsAnswers);



        });   //if answer is incorrect, add 1 to questionNo and generate new question and Answersi

        incorrectOne.setOnAction( e -> {

            incorrectAnswerChosen(primaryStage, questions, questionsAnswers);
            //if answer is incorrect, add 1 to questionNo and generate new question and Answers

        });

        incorrectTwo.setOnAction( e -> {

            incorrectAnswerChosen(primaryStage, questions, questionsAnswers);
            //if answer is incorrect, add 1 to questionNo and generate new question and Answers

        });

        incorrectThree.setOnAction( e -> {
            incorrectAnswerChosen(primaryStage, questions, questionsAnswers);
            //if answer is incorrect, add 1 to questionNo and generate new question and Answers

        });


}

        public static void quizOver(Stage primaryStage) {

       primaryStage.close();

       Stage newPrimaryStage = new Stage();

        Label GameOver = new Label ("Quiz complete");
        Label userScore = new Label ("You Scored " + Quiz.score + " Out of 10!");
        Label tryAgin = new Label ("Try again?");

        Button retry = new Button ("Retry");
        retry.setOnAction(e -> quizMenu() );
        Label Fact = new Label("Fact will appear here");


         VBox layout = new VBox();
         layout.getChildren().addAll( GameOver, userScore, tryAgin, retry, Fact);
         Scene scene = new Scene(layout, 800, 600);
         newPrimaryStage.setScene(scene);
         newPrimaryStage.show();



        }



    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
























