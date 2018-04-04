package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Quiz extends Application {




    public static String[] randomAnswers = new String[3];
    public static int score;
    public static int questionNo;





    public static void generateQuestionsAndAnswers(String Difficulty, String difficultyAnswers) throws FileNotFoundException {
// Generates the questions


        List<String> list = new LinkedList<>();
        File QuestionsE = new File(Difficulty); //Loads question text file

        Scanner scanner = new Scanner(QuestionsE);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        String questions[] = list.toArray(new String[list.size()]); //puts all questions in array


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

    public static void checkAnswer(String questionAnswers[]) {


        int i = questionAnswers.length;
        String[] Answers = Arrays.copyOf(questionAnswers, i);


        List<String> answerChecker = Arrays.asList(Answers);
        List<String> answerRandom = answerChecker;

        Collections.shuffle(answerRandom);

        Stack<String> answerStack = new Stack<>();

        answerStack.addAll(answerRandom);



        Quiz.randomAnswers[0] = answerStack.pop();
        Quiz.randomAnswers[1] = answerStack.pop();
        Quiz.randomAnswers[2] = answerStack.pop();




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

        Stage primaryStage = new Stage();
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


        HBox topMenu = new HBox();
        topMenu.setAlignment(Pos.CENTER);
        topMenu.setPadding(new Insets(80,20,20,20));
        Text quizText = new Text("Welcome to the Test!");
        quizText.setFont(new Font("Arial", 45));
        topMenu.getChildren().addAll(quizText);



        //Difficulty selection
        VBox middleMenu = new VBox();
        middleMenu.setAlignment(Pos.CENTER);
        middleMenu.setPadding( new Insets (0,20,20, 20));
        middleMenu.setSpacing(10);
        Text difficultyText = new Text ("Select your difficulty");
        difficultyText.setFont(new Font ("Arial", 29));
        Button easyButton = new Button("Easy");
        Button mediumButton = new Button("Medium");
        Button hardButton = new Button("Hard");
        middleMenu.getChildren().addAll(difficultyText,easyButton,mediumButton,hardButton);

        HBox bottomMenu = new HBox();
        bottomMenu.setAlignment(Pos.CENTER);
        Button menu = new Button ("Menu");
        Button about = new Button ("About");
        Button info = new Button ("Info");
        Button toolKit = new Button ("Toolkit");
        bottomMenu.getChildren().addAll(menu, about, info, toolKit);

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(topMenu);
        borderpane.setCenter(middleMenu);
        borderpane.setBottom(bottomMenu);


        Scene scene = new Scene(borderpane, 800, 600);
        scene.getStylesheets().add("/Sample/Quiz.css");
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
        String Question[] = Quiz.displayQuestions(questions, questionsAnswers);

        checkAnswer(questionsAnswers);

        do {
            Quiz.checkAnswer(questionsAnswers);
        } while (Question[1] == Quiz.randomAnswers[0] || Question[1] == Quiz.randomAnswers[1] || Question[1] == Quiz.randomAnswers[2]);

        Label questionNumberLabel = new Label("Question " + Quiz.questionNo + " Out of 10");
        Label questionLabel = new Label(Question[0]); //Display Question on screen
        Button correctAnswer = new Button(Question[1]); //correct answer always on the same button, but button will move
        Button incorrectOne = new Button(Quiz.randomAnswers[0]);
        Button incorrectTwo = new Button (Quiz.randomAnswers[1]);
        Button incorrectThree = new Button(Quiz.randomAnswers[2]);



        ArrayList<Button> Answers = new ArrayList<>(); //Take all answers, put them into Array List, so they can be placed at random locations.

        Answers.add(correctAnswer);
        Answers.add(incorrectOne);
        Answers.add(incorrectTwo);
        Answers.add(incorrectThree);

        Collections.shuffle(Answers);

        System.out.println(Answers.get(0));
        System.out.println(Answers.get(1));
        System.out.println(Answers.get(2));
        System.out.println(Answers.get(3));


        VBox layout = new VBox();
        layout.getChildren().addAll( questionNumberLabel, questionLabel,Answers.get(0), Answers.get(1), Answers.get(2), Answers.get(3));
        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        correctAnswer.setOnAction(e -> {

            correctAnswerChosen(primaryStage, questions, questionsAnswers);



        }); //if answer is incorrect, add 1 to questionNo and generate new question and Answers  //if answer is incorrect, add 1 to questionNo and generate new question and Answersi

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

        DBconnect connect = new DBconnect();
        connect.getData();

        primaryStage.close();

        VBox content = new VBox();
        Stage newPrimaryStage = new Stage();


        Label gameOver = new Label ("Quiz complete");
        Label userScore = new Label ("You Scored " + Quiz.score + " Out of 10!");


        Label tryAgin = new Label ("Try again?");
        Button retry = new Button ("Retry");
        Text enterName = new Text ("Please enter your nickname to be added to the LeaderBoard");
        TextField nameSubmission = new TextField();

        Button submit = new Button("Enter");
        retry.setOnAction(e -> quizMenu() );

        submit.setOnAction(e->
        {


            try {
                connect.addData(nameSubmission.getText(), Quiz.score);
                alertBox.display("Nickname Added!", "Your Nickname has been added! Your score won't show right now, but if you've made it onto the leaderboard, It'll be there next time! Thanks for playing!", "Okay!");
            }
            catch (Exception exc) {
                System.out.print(exc);

            }
        });




        Text lBoard = new Text ("LeaderBoard");
        //  Image trophy = new Image("/sample/Trophy.PNG");


        Text firstPlace = new Text ((String.format("1. %s", connect.nickNames.pop() + " Score: " +connect.userScores.pop())));
        Text secondPlace = new Text((String.format("2. %s", connect.nickNames.pop() + " Score: " +connect.userScores.pop())));
        Text thirdPlace = new Text ((String.format("3. %s", connect.nickNames.pop() + " Score: " + connect.userScores.pop())));



        HBox fact = new HBox();
        Label Fact = new Label("Fact will appear here");


        HBox bottomMenu = new HBox();
        bottomMenu.setAlignment(Pos.CENTER);
        Button menu = new Button ("Menu");
        Button about = new Button ("About");
        Button info = new Button ("Info");
        Button toolKit = new Button ("Toolkit");
        bottomMenu.getChildren().addAll(menu, about, info, toolKit);




        content.getChildren().addAll(gameOver, userScore, tryAgin, retry, enterName, nameSubmission, submit, lBoard, firstPlace, secondPlace, thirdPlace, fact, Fact);
        Scene scene = new Scene(content, 600, 800 );
        newPrimaryStage.setScene(scene);
        newPrimaryStage.show();



    }



    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}