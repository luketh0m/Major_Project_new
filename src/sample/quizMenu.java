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

    public static String Easy = "easyQuestions.txt";
    String Medium = "mediumQuestions.txt";
    String Hard = "hardQuestions.txt";

    String easyAnswer = "easyQuestionsAnswers.txt";
    String mediumAnswer = "mediumQuestionsAnswers.txt";
    String hardAnswer = "hardQuestionsAnswers.txt";

    public void appAcessed() {
        //displays background options
        optionsController.tintOptions(Tint);
    }

    public void quizStart(String Difficulty, String DifficultyAnswers) throws Exception {
        // generates questions and answers, and runs quiz
        Quiz.generateQuestionsAndAnswers(Difficulty, DifficultyAnswers);
    }

    public void easyQuiz() throws Exception {
        //runs Quiz with easy questions
        quizStart(Easy, easyAnswer);
    }

    public void mediumQuiz() throws Exception {
        //runs Quiz with medium questions
        quizStart(Medium, mediumAnswer);
    }

    public void hardQuiz() throws Exception {
        //runs Quiz with hard questions
        quizStart(Hard, hardAnswer);
    }

    public void menuButtonClicked() throws Exception {
        //opens main menu
        primaryStage.close();
        Main.currentPage = "sample.fxml";
        m.start(primaryStage);
    }


    public void settingsButtonClicked() throws Exception {
        //opens settings menu
        primaryStage.close();
        Main.currentPage = "Options.fxml";
        m.start(primaryStage);
    }

    public void infoButtonClicked()  {
        //display info about application
        c.infoButton();
    }

    public void quizButtonClicked() throws Exception {
        //opens quiz menu
        primaryStage.close();
        Main.currentPage = "Phone.fxml";
        m.start(primaryStage);
    }

    @Override
    public void start(Stage primaryStage){
    }
}