package phj233;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){

        Stage stage = new Stage();
        stage.setTitle("图书管理系统");
        stage.getIcons().add(new Image("img/icon.png"));
        stage.setWidth(550);
        stage.setHeight(450);
        stage.show();

        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color:#FFF5EE");
    }

}
