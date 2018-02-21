package sample;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.*;
import  javafx.scene.text.Text;



public class onClick {


    public static void display(String Info) {

        Stage window = new Stage();


        Text description = new Text(Info);
        Button loadHardware = new Button("Try out the hardware");

        VBox layout = new VBox(5);
        layout.getChildren().addAll(description, loadHardware);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();



    }

}




