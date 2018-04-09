package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class quizMenu extends Application {


    AnchorPane pane;
    @FXML
    static Pane rootPane;
    @FXML
    static Button easyButton;
    @FXML
    static Button mediumButton;
    @FXML
    static Button hardButton;


    public static  String Easy = "easyQuestions.txt";
    String Medium = "mediumQuestions.txt";
    String Hard = "hardQuestions.txt";

    String easyAnswer = "easyQuestionsAnswers.txt";
    String mediumAnswer = "mediumQuestionsAnswers.txt";
    String hardAnswer = "hardQuestionsAnswers.txt";

    public static void quizDifficulty() {

        Stage primaryStage = new Stage();
        Quiz quiz = new Quiz();

        quiz.score = 0;
        quiz.questionNo = 1;


        // Text files of question and answers




    }
    public void quizStart(String Difficulty, String DifficultyAnswers) throws Exception {

        Quiz.generateQuestionsAndAnswers(Difficulty, DifficultyAnswers);
    }


    public void easyQuiz() throws Exception {

        quizStart(Easy,easyAnswer);
    }

    public void mediumQuiz() throws Exception {

        quizStart(Medium,mediumAnswer);
    }
    public void hardQuiz() throws Exception {

        quizStart(Hard,hardAnswer);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}