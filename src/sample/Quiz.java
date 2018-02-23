package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.*;
import java.util.*;

public class Quiz {


    Button hint = new Button();


    public static void generateQuestionsAndAnswers(String Difficulty, String DifficultyAnswers) throws FileNotFoundException { //this generates the questions, based on difficulty chosen

// Generates the questions




        List<String> list = new LinkedList<>();
        File QuestionsE = new File(Difficulty); //Loads question text file

        Scanner scanner = new Scanner(QuestionsE);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        String easyQuestions[] = list.toArray(new String[list.size()]); //puts all questions in array

        int numberOfQuestions = easyQuestions.length;

        //Generate Question

        Random r = new Random(); //
        int randomIndexOfQuestions = r.nextInt(numberOfQuestions);
        Label Questions = new Label(easyQuestions[randomIndexOfQuestions]);


// Generate Correct Answer

        List<String> listA = new LinkedList<>(); //Create a new list
        File QuestionsA = new File(DifficultyAnswers); //Loads question text file

        Scanner scannerA = new Scanner(QuestionsA); //Look at text file with answers on

        while (scannerA.hasNextLine()) { //Add each line of answers to list, new line = new answer
            listA.add(scannerA.nextLine());
        }

        String QuestionsAnswers[] = listA.toArray(new String[listA.size()]); //puts all answers in array, same order as questions


        Random wrongAnswer1 = new Random();
        Random wrongAnswer2 = new Random();
        Random wrongAnswer3 = new Random();

        int randomAnswerOne = wrongAnswer1.nextInt(numberOfQuestions);
        int randomAnswerTwo = wrongAnswer2.nextInt(numberOfQuestions);
        int randomAnswerThree = wrongAnswer3.nextInt(numberOfQuestions);

        if (randomAnswerOne == randomIndexOfQuestions || randomAnswerOne == randomAnswerTwo || randomAnswerOne == randomAnswerThree) {

            randomAnswerOne = randomAnswerOne + randomAnswerTwo / 2;
        }

        if (randomAnswerTwo == randomIndexOfQuestions || randomAnswerTwo == randomAnswerThree) {

            randomAnswerTwo = randomAnswerTwo + randomAnswerOne / 2;
        }

        if (randomAnswerThree == randomIndexOfQuestions) {

            randomAnswerThree = randomAnswerThree + randomAnswerTwo / 2;
        }



        // Store answers ready for display
        String Answers = (QuestionsAnswers[randomIndexOfQuestions]); //Create a string of the correct answer
        String wAnswer1 = (QuestionsAnswers[randomAnswerOne]);
        String wAnswer2 = (QuestionsAnswers[randomAnswerTwo]);
        String wAnswer3 = (QuestionsAnswers[randomAnswerThree]);


        Quiz.quizGame(Questions, Answers, wAnswer1, wAnswer2, wAnswer3);
        System.out.println(randomAnswerOne);
        System.out.println(randomAnswerTwo);
        System.out.println(randomAnswerThree);
        System.out.println(randomIndexOfQuestions);


    }


    public static void quizMenu() {
        String Easy = "easyQuestions.txt";
        String Medium = "mediumQuestions.txt";
        String Hard = "hardQuestions.txt";

        String easyAnswers = "easyQuestionsAnswers.txt";
        String mediumAnswers = "mediumQuestionsAnswers.txt";
        String hardAnswers = "hardQuestionsAnswers.txt";


        Stage primaryStage = new Stage();
        Button easyButton = new Button("Easy");
        Button mediumButton = new Button("Medium");
        Button hardButton = new Button("Hard");

        VBox layout = new VBox();
        layout.getChildren().addAll(easyButton, mediumButton, hardButton);


        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        easyButton.setOnAction(e -> {

            try {
                generateQuestionsAndAnswers(Easy, easyAnswers);

            } catch (FileNotFoundException exc) {
                System.out.print(exc);

            }

        });


        mediumButton.setOnAction(e -> {

            try {
                generateQuestionsAndAnswers(Medium, mediumAnswers);

            } catch (FileNotFoundException exc) {
                System.out.print(exc);

            }

        });


        hardButton.setOnAction(e -> {

            try {
                generateQuestionsAndAnswers(Hard, hardAnswers);

            } catch (FileNotFoundException exc) {
                System.out.print(exc);

            }

        });

    }




    public static void quizGame(Label Questions, String Answer, String wAnswer1, String wAnswer2, String wAnswer3) {




        Stage primaryStage = new Stage();
        primaryStage.setTitle("Quiz");
        VBox layout = new VBox(20);






        Button correctAnswer = new Button(Answer);
        Button incorrectAnswer1 = new Button(wAnswer1);
        Button incorrectAnswer2 = new Button(wAnswer2);
        Button incorrectAnswer3 = new Button(wAnswer3);




            layout.getChildren().addAll(Questions, correctAnswer, incorrectAnswer1, incorrectAnswer2, incorrectAnswer3);
            Scene scene = new Scene(layout, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Difficulty");
            primaryStage.show();




        }








}

























