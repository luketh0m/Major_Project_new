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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.FileNotFoundException;

import static sample.optionsController.primaryStage;

public class quizMenu extends Application {


    Controller c = new Controller();
    Main m = new Main();
    optionsController o = new optionsController();
    AnchorPane pane;
    @FXML
    static Pane rootPane;
    @FXML
    static Button easyButton;
    @FXML
    static Button mediumButton;
    @FXML
    static Button hardButton;
    @FXML
     private Rectangle Tint;


    public static  String Easy = "easyQuestions.txt";
    String Medium = "mediumQuestions.txt";
    String Hard = "hardQuestions.txt";

    String easyAnswer = "easyQuestionsAnswers.txt";
    String mediumAnswer = "mediumQuestionsAnswers.txt";
    String hardAnswer = "hardQuestionsAnswers.txt";





    public void appAcessed() {
        optionsController.tintOptions(Tint);


    }


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

    public void menuButtonClicked() throws Exception {
        primaryStage.close();
        Main.currentPage = "sample.fxml";
        m.start(primaryStage);


    }


    public void settingsButtonClicked() throws Exception {
        primaryStage.close();
        Main.currentPage = "Options.fxml";
        m.start(primaryStage);

    }

    public void infoButtonClicked() throws Exception {

        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        primaryStage.close();
        Main.currentPage = "Phone.fxml";
        m.start(primaryStage);


    }
        public void closePage() throws Exception {

            Window window = rootPane.getScene().getWindow();
            if (window instanceof Stage) {


                ((Stage) window).close();
            }
        }





    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}