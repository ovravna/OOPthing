package JavaFXthing;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;


        Label lable1 = new Label("Dette er ikke en kake.");
        Button button1 = new Button("Scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        window.setOnCloseRequest(e -> {
            e.consume();
            if (ConfirmBox.isFine("Wonna Close?")) window.close();
        });


        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(lable1, button1);
        scene1 = new Scene(layout1, 200, 200);
        layout1.setAlignment(Pos.CENTER);

        Button button2 = new Button("Scene 1");

        button2.setOnAction(event -> {
            boolean isK = ConfirmBox.isFine("You want some kake?");
            System.out.println(isK ? "The cake is a lie!":"Y u no want ze kake?");
        });


        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(new Label("Dette er heller ikke en kake!"), button2);
        scene2 = new Scene(layout2, 200, 200);
        layout2.setAlignment(Pos.CENTER);

        window.setScene(scene1);
        window.setTitle("Title");
        window.show();
    }

}
