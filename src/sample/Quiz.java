package sample;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Quiz extends Application {




    public static String[] randomAnswers = new String[3];
    public static int score;
    public static int questionNo = 1;
    public static   Main m = new Main();




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

        String qAndA[] = new String [2];
        qAndA [0]  = questions[questionNo];
        qAndA [1] = questionsAnswers[questionNo];


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

        quiz.score = 0;
        quiz.questionNo = 1;

    }



    public static void quizGame (String questions[], String questionsAnswers[]) {

        Reflection R = new Reflection();
        Stage primaryStage = new Stage();
        String Question[] = Quiz.displayQuestions(questions, questionsAnswers);

        checkAnswer(questionsAnswers);

        do {
            Quiz.checkAnswer(questionsAnswers);
        } while (Question[1] == Quiz.randomAnswers[0] || Question[1] == Quiz.randomAnswers[1] || Question[1] == Quiz.randomAnswers[2]);


        Rectangle background = new Rectangle();
        background.setWidth(800);
        background.setHeight(600);
        background.setFill(Color.web("#ddfff7"));

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




        AnchorPane  layout = new AnchorPane();
        GridPane grid = new GridPane();
        grid.add(Answers.get(0), 0, 0);
        grid.add(Answers.get(1), 0, 1);
        grid.add(Answers.get(2), 1, 0);
        grid.add(Answers.get(3), 1, 1);
        grid.setGridLinesVisible(false);



        correctAnswer.setPrefHeight(75);
        correctAnswer.setPrefWidth(168);
        correctAnswer.setEffect(R);


        incorrectOne.setPrefHeight(75);
        incorrectOne.setPrefWidth(168);
        incorrectOne.setEffect(R);


        incorrectTwo.setPrefHeight(75);
        incorrectTwo.setPrefWidth(168);
        incorrectTwo.setEffect(R);

        incorrectThree.setPrefHeight(75);
        incorrectThree.setPrefWidth(168);
        incorrectThree.setEffect(R);


        Line questionLink1 = new Line();
        Line questionLink2 = new Line();
        Line questionLink3 = new Line();
        Line questionLink4 = new Line();

        questionLink1.setEndX(200);
        questionLink1.setStartX(0);
        questionLink1.setStartY(330);
        questionLink1.setEndY(330);

        questionLink2.setEndX(600);
        questionLink2.setStartX(800);
        questionLink2.setStartY(330);
        questionLink2.setEndY(330);


        questionLink3.setEndX(200);
        questionLink3.setStartX(0);
        questionLink3.setStartY(475);
        questionLink3.setEndY(475);

        questionLink4.setEndX(600);
        questionLink4.setStartX(800);
        questionLink4.setStartY(475);
        questionLink4.setEndY(475);



        questionNumberLabel.setFont(new Font("curlz MT", 25));
        questionNumberLabel.setTextFill(Color.web("#114b5f"));
        questionNumberLabel.setLayoutX(10);
        questionNumberLabel.setLayoutY(1);

        VBox questionBox = new VBox();
        questionLabel.setFont(new Font("curlz MT", 30));
        questionLabel.setTextFill(Color.web("#114b5f"));
        questionLabel.setLayoutX(10);
        questionLabel.setLayoutY(100);
        questionLabel.setMaxWidth(800);

        questionBox.getChildren().add(questionLabel);
        questionBox.setLayoutX(10);
        questionBox.setLayoutY(100);
        questionBox.setMaxWidth(800);
        questionBox.setFillWidth(true);
        grid.setLayoutX(40);
        grid.setLayoutY(239);
        grid.setPrefHeight(309);
        grid.setPrefWidth(721);
        grid.setVgap(50);
        grid.setHgap(150);

       grid.setAlignment(Pos.CENTER);

        Rectangle bottomMenu = new Rectangle();
        bottomMenu.setWidth(800);
        bottomMenu.setHeight(38);
        bottomMenu.setLayoutY(562);
        bottomMenu.setFill(Color.WHITE);

        Button menuButton = new Button("Menu");
        Button aboutButton = new Button("About");
        Button infoButton = new Button("Info");
        Button toolkitButton = new Button("Toolkit");

        menuButton.setLayoutX(130);
        menuButton.setLayoutY(562);
        menuButton.setPrefHeight(38);
        menuButton.setPrefWidth(118);

       aboutButton.setLayoutX(260);
        aboutButton.setLayoutY(562);
        aboutButton.setPrefHeight(38);
        aboutButton.setPrefWidth(118);

        infoButton.setLayoutX(390);
        infoButton.setLayoutY(562);
        infoButton.setPrefHeight(38);
        infoButton.setPrefWidth(118);

       toolkitButton.setLayoutX(520);
       toolkitButton.setLayoutY(562);
       toolkitButton.setPrefHeight(38);
        toolkitButton.setPrefWidth(118);


        layout.getChildren().addAll( background, questionNumberLabel, questionBox, questionLink1, questionLink2,questionLink3, questionLink4, grid, bottomMenu, menuButton, infoButton,aboutButton,toolkitButton);



        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.show();

        scene.getStylesheets().add
                (Quiz.class.getResource(optionsController.fontSize).toExternalForm());
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



    public static String factGenerator () throws FileNotFoundException {


        List<String> list = new LinkedList<>();
        File factsFile = new File("Facts.txt"); //Loads question text file

        Scanner scanner = new Scanner(factsFile);

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        String facts[] = list.toArray(new String[list.size()]);


        List<String> factsList = Arrays.asList(facts);

        Stack<String> factStack = new Stack<>();

        factStack.addAll(factsList);

        String fact = factStack.pop();

        return fact;

    }


    public static void quizOver(Stage primaryStage) {



        Reflection r = new Reflection();
        Font f = new Font("Curlz MT", 32);
        Font l = new Font("Curlz MT", 20);

        DBconnect connect = new DBconnect();
        connect.getData();

        primaryStage.close();

       AnchorPane pane = new AnchorPane();
       Rectangle background = new Rectangle();
       background.setHeight(600);
       background.setWidth(800);
       background.setFill(Color.web("#ddfff7"));
       pane.setPrefHeight(600);
       pane.setPrefWidth(800);
       Stage newPrimaryStage = new Stage();


        Text gameOver = new Text ("Quiz complete");
        gameOver.setLayoutX(258.0);
        gameOver.setLayoutY(53);
        gameOver.setFont(new Font("Curlz MT", 52));

        gameOver.setEffect(r);

        Text userScore = new Text ("You Scored " + Quiz.score + " Out of 10!");
        userScore.setLayoutX(258);
        userScore.setLayoutY(103);
        userScore.setFont(f);


        Text tryAgin = new Text ("Try again?");
        tryAgin.setLayoutX(350);
        tryAgin.setLayoutY(213);
        tryAgin.setFont(f);

        Button retry = new Button ("Retry");
        retry.setOnAction(e ->  {
            primaryStage.close();
            Main.currentPage = "welcomeQuiz.fxml";

            try {
                questionNo =1;
                score =0;
                m.start(primaryStage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });
        retry.setLayoutX(350);
        retry.setLayoutY(238);
        retry.setPrefWidth(131);
        retry.setPrefHeight(30);
        retry.setFont(new Font("Curlz MT", 14));

        Text enterName = new Text ("Please enter your nickname to be added to the LeaderBoard");
        enterName.setLayoutX(260);
        enterName.setLayoutY(340);
        enterName.setFont(new Font("Curlz MT", 20));
        enterName.setEffect(r);

        TextField nameSubmission = new TextField();
        nameSubmission.setLayoutX(260);
        nameSubmission.setLayoutY(370);

        Button submit = new Button("Enter");
        submit.setLayoutX(532);
        submit.setLayoutY(370);
        submit.setFont(f);


        submit.setOnAction(e->
        {


            try {
                connect.addData(nameSubmission.getText(), Quiz.score);
                alertBox.display("Nickname Added!", "Your Nickname has been added! Your score won't show right now, but if you've made it onto the leaderboard, It'll be there next time! Thanks for playing!", "Okay!");
            }
            catch (Exception exc) {
                alertBox.display("Error!", "Sorry, your score couldn't be added at this time. Please try again later", "Okay");

            }
        });




        Text lBoard = new Text ("LeaderBoard");
        lBoard.setLayoutX(65);
        lBoard.setLayoutY(213);
        lBoard.setFont(l);

        // Image trophy


        Text firstPlace = new Text ((String.format("1. %s", connect.nickNames.pop() + " Score: " +connect.userScores.pop())));
        firstPlace.setLayoutX(65);
        firstPlace.setLayoutY(240);
        firstPlace.setFont(l);

        Text secondPlace = new Text((String.format("2. %s", connect.nickNames.pop() + " Score: " +connect.userScores.pop())));
        secondPlace.setLayoutX(65);
        secondPlace.setLayoutY(290);
        secondPlace.setFont(l);

        Text thirdPlace = new Text ((String.format("3. %s", connect.nickNames.pop() + " Score: " + connect.userScores.pop())));
        thirdPlace.setLayoutX(65);
        thirdPlace.setLayoutY(340);
        thirdPlace.setFont(l);



        Rectangle factBoarder = new Rectangle();
        factBoarder.setArcHeight(5);
        factBoarder.setArcWidth(5);
        factBoarder.setWidth(400);
        factBoarder.setHeight(43);
        factBoarder.setLayoutX(248);
        factBoarder.setLayoutY(450);
        factBoarder.setStrokeType(StrokeType.INSIDE);
       factBoarder.setFill(Color.web("#7aafe1"));

        Text fact = null;
        try {
            fact = new Text("Fact: " + Quiz.factGenerator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fact.setLayoutX(248);
       fact.setLayoutY(481);
       fact.setFont(l);





        Button menu = new Button ("Menu");
        menu.setLayoutX(171);
        menu.setLayoutY(566);

        Button about = new Button ("About");
        about.setLayoutX(271);
        about.setLayoutY(566);

        Button info = new Button ("Info");
        info.setLayoutX(371);
        info.setLayoutY(566);

        Button toolKit = new Button ("Toolkit");
        toolKit.setLayoutX(471);
        toolKit.setLayoutY(566);





        pane.getChildren().addAll( background, gameOver, userScore, tryAgin, retry, enterName, nameSubmission, submit, lBoard, firstPlace, secondPlace, thirdPlace, factBoarder, fact, menu, about, info, toolKit);
        Scene scene = new Scene(pane, 800, 600 );
        scene.getStylesheets().add(optionsController.fontSize);
        newPrimaryStage.setScene(scene);

        newPrimaryStage.show();



    }






    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}