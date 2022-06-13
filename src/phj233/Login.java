package phj233;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Optional;
import  java.sql.*;

public class Login extends Application {
    public static void main(String[] args) {
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (SQLException se){
//
//        }

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("图书管理系统--管理员登录");
        stage.getIcons().add(new Image("img/icon.png"));
        stage.setWidth(600);
        stage.setHeight(400);

        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color:#FFF5EE");
        Label l_name =new Label("账号：");
        Label l_passwd = new Label("密码：");
        Label l_sql = new Label("SQL地址：");
        Label l_sql_name = new Label("SQL用户：");
        Label l_sql_passwd = new Label("SQL密码：");

        TextField t_name = new TextField();
        TextField t_sql_name = new TextField();
        PasswordField p_sql_passwd = new PasswordField();
        TextField t_sql = new TextField("mysql://local:22/book");
        PasswordField p_passwd = new PasswordField();
        //t_name.getProperties().put("phj233","123456");
        t_name.setUserData("phj233");
        p_passwd.setUserData("123456");
        Button login = new Button("登录");
        Button clear = new Button("清除");
        Button connect = new Button("连接");

        gr.setAlignment(Pos.CENTER);
        gr.setHgap(5);
        gr.setVgap(15);
        gr.add(l_sql_name,0,1);
        l_sql_name.setFont(Font.font(15));
        gr.add(t_sql_name,1,1);
        gr.add(l_sql_passwd,2,1);
        l_sql_passwd.setFont(Font.font(15));
        gr.add(p_sql_passwd,3,1);
        gr.add(l_sql,0,2);
        l_sql.setFont(Font.font(15));
        gr.add(t_sql,1,2);
        gr.add(connect,2,2);
        gr.add(l_name,0,3);
        l_name.setFont(Font.font(15));
        gr.add(t_name,1,3);
        gr.add(l_passwd,2,3);
        l_passwd.setFont(Font.font(15));
        gr.add(p_passwd,3,3);
        gr.add(clear,2,4);
        gr.add(login,3,4);
        GridPane.setMargin(login,new Insets(0,0,0,120));

//      BorderPane root = new BorderPane();
        Scene scene = new Scene(gr,400,250);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest(event ->{
            event.consume();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("图书管理系统");
            alert.setHeaderText(null);
            alert.setContentText("您是否退出登录？");
            Optional<ButtonType> result=alert.showAndWait();
            if (result.get()==ButtonType.OK){
                Platform.exit();
            }
        });
        connect.setOnAction(actionEvent -> {
                String sql_url = "jdbc:"+t_sql.getText()+"?useUnicode=true&characterEncoding=UTF-8";
        });
        clear.setOnAction(actionEvent -> {
            t_name.setText("");
            p_passwd.setText("");
        });
        login.setOnAction(actionEvent -> {
            String name = (String) t_name.getUserData();
            String passwd = (String) p_passwd.getUserData();
            if (name.equals(t_name.getText()) && passwd.equals(p_passwd.getText())){
                System.out.println("success");
                Main main =new Main();
                try {
                    main.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                stage.hide();
            }else{
                System.out.println("寄");


            }
        });
        stage.show();
        
    }
}
