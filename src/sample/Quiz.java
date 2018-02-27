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

      String value = generateRandomAnswer(questionsAnswers);







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
                generateQuestionsAndAnswers(Easy, easyAnswer);


            } catch (FileNotFoundException notFound) {
                System.out.print(notFound);

            }


        });

    }


}
























