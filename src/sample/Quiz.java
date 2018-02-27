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
import java.lang.reflect.Array;
import java.util.*;

public class Quiz {


    public static void generateQuestions(String Difficulty, String difficultyAnswers) throws FileNotFoundException {
// Generates the questions


        List<String> list = new LinkedList<>();
        File QuestionsE = new File(Difficulty); //Loads question text file

        Scanner scanner = new Scanner(QuestionsE);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        String Questions[] = list.toArray(new String[list.size()]); //puts all questions in array

        int numberOfQuestions = Questions.length;

        //Generate Question

        Random r = new Random(); //
        int indexOfQuestions = r.nextInt(numberOfQuestions);

        List<String> listA = new LinkedList<>(); //Create a new list
        File QuestionsA = new File(difficultyAnswers); //Loads question text file

        Scanner scannerA = new Scanner(QuestionsA); //Look at text file with answers on

        while (scannerA.hasNextLine()) { //Add each line of answers to list, new line = new answer
            listA.add(scannerA.nextLine());
        }

        String questionsAnswers[] = listA.toArray(new String[listA.size()]); //puts all answers in array, same order as questions


        displayQuestion(Questions, indexOfQuestions);
        displayAnswers(questionsAnswers, indexOfQuestions);
        displayIncorrecrAnswers(questionsAnswers, indexOfQuestions);
    }


// Generate Correct Answer


    public static void displayQuestion(String question[], int indexOfQuestions) throws FileNotFoundException {


        Label questionsLabel = new Label(question[indexOfQuestions]); //create a label to display said questions.
        System.out.print(question[indexOfQuestions]);

    }


    public static void displayAnswers(String answers[], int indexOfQuestions) throws FileNotFoundException {


        Button correctAnswer = new Button(answers[indexOfQuestions]);
        System.out.print(answers[indexOfQuestions]);

    }


    public static void displayIncorrecrAnswers(String answers[], int indexOfQuestions) throws FileNotFoundException {

        Random wrongAnswer = new Random(); //creates a random to choose random answers

        int randomAnswer = wrongAnswer.nextInt(indexOfQuestions);

        System.out.print(randomAnswer);
        if (randomAnswer == indexOfQuestions) {

            randomAnswer = wrongAnswer.nextInt(indexOfQuestions);


            Button incorrectAnswer = new Button(answers[randomAnswer]);
            System.out.print(answers[randomAnswer]);

        }

    }

    public static void quizContent() {


        String Easy = "easyQuestions.txt";
        String Medium = "mediumQuestions.txt";
        String Hard = "hardQuestions.txt";

        String easyAnswer = "easyQuestionsAnswers.txt";
        String mediumAnswer = "mediumQuestionsAnswer.txt";
        String hardAnswer = "hardQuestionsAnswer.txt";


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
                generateQuestions(Easy, easyAnswer
                );


            } catch (FileNotFoundException notFound) {
                System.out.print(notFound);

            }


        });

    }


    public static void quizGame(Label questionsLabel) {


        Stage primaryStage = new Stage();
        primaryStage.setTitle("Quiz");
        VBox layout = new VBox(20);


        layout.getChildren().addAll(questionsLabel);
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Difficulty");
        primaryStage.show();

    }


}
























