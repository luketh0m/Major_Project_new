package sample;


import javafx.geometry.Pos;

import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.*;
import javafx.scene.control.*;

public class alertBox {

    public static void display(String title, String message, String buttonText) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button(buttonText);
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}