package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.shape.*;

import static javafx.scene.paint.Color.WHITE;


public class Phone  {

    public static void Toolkit()  {
        Stage primaryStage = new Stage();

        AnchorPane pane = new AnchorPane();
        pane.maxHeight(800);
        pane.maxWidth(600);
        pane.minHeight(800);
        pane.minWidth(600);

        Group phoneGroup = new Group();
        phoneGroup.setLayoutX(42);
        phoneGroup.setLayoutY(103);

        Rectangle phoneOutLine = new Rectangle();
        phoneOutLine.setLayoutX(3);
        phoneOutLine.setHeight(370);
        phoneOutLine.setWidth(296);
        phoneOutLine.setFill(WHITE);


        Tooltip t = new Tooltip("This is a phone");
        Tooltip.install(phoneOutLine, t);

        phoneGroup.getChildren().addAll(phoneOutLine);
        pane.getChildren().addAll(phoneGroup);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}