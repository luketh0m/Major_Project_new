package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import java.beans.EventHandler;
import java.io.*;
import java.util.*;
public class Quiz {


    int questionNumber = 1;

    Button Answer1 = new Button();
    Button Answer2 = new Button();
    Button Answer3 = new Button();
    Button Answer24 = new Button();


    String correctAnswer;

    String wrongAnswer1;
    String wrongAnswer2;
    String wrongAnswer3;
    String wrongAnswer4;

    int Score;

    Button hint = new Button();




    public static void generateQuestions(String Difficulty) throws FileNotFoundException { //this generates the questions, based on difficulty chosen


        List<String> list = new LinkedList<>();
        File QuestionsE = new File(Difficulty); //Loads question text file

        Scanner scanner = new Scanner(QuestionsE);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        String easyQuestions[] = list.toArray(new String[list.size()]); //puts all questions in array

        int numberOfQuestions = easyQuestions.length;
        Random r = new Random();

        int randomIndexOfQuestions = r.nextInt(numberOfQuestions);
        Label Questions = new Label(easyQuestions[randomIndexOfQuestions]);

            Quiz.quizGame(Questions);
            System.out.print("It works");
        }
    public static void quizMenu()  { // Load FXML document and display on screen
        String Easy = "questionPageOne.txt";
        String Medium = "";
        String Hard = "";


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
                generateQuestions(Easy);

            }
            catch (FileNotFoundException exc)
            {
                System.out.print(exc);

            }

        });


    }


    public static void quizGame(Label Questions){

        Stage primaryStage = new Stage();
       primaryStage.setTitle("Quiz");
       VBox layout = new VBox(20);
       layout.getChildren().addAll(Questions);
       Scene scene = new Scene(layout, 800 ,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Difficulty");
        primaryStage.show();



    }


}

































