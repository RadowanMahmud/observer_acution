package youtbe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.FirstUser;
import user.SecondUser;
import user.observer;
import user.ThirdUser;

import java.util.Scanner;

public class main extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//
//
//    }
//    public static void main(String[] args) throws IOException {
//        launch(args);
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Welcome To Bidding System");
        primaryStage.setScene(new Scene(root, 600, 410));
        primaryStage.show();


//        int ch,ch1;
//        while(true){
//            System.out.println("Bid by 1.a 2.b 3.c");
//            ch=cin.nextInt();
//            System.out.println("Enter bidding amount");
//            ch1=cin.nextInt();
//            if(ch==1){
//                u.upload(a,ch1);
//            }
//            else if(ch==2){
//                u.upload(b,ch1);
//            }
//            else if(ch==3){
//                u.upload(c,ch1);
//            }
//        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
