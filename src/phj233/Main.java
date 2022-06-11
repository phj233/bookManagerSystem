package phj233;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("图书管理系统");
        primaryStage.getIcons().add(new Image("img/icon.png"));
        primaryStage.setWidth(550);
        primaryStage.setHeight(450);

        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color:#FFF5EE");
        Label l_name =new Label("账号：");
        Label l_passwd = new Label("密码：");
        primaryStage.show();

    }

}
