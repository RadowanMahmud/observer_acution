package user;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.io.IOException;

public class ThirdUser implements observer{

    String name = "";

    Label label = new Label("Bidding Situation");
    Label error = new Label("Current State");
    GridPane components = new GridPane();

    public ThirdUser(String na) throws IOException {
        name = na;
        Stage stage = new Stage();

        label.setFont(Font.font ("Verdana", 17));
        components.setStyle("-fx-background-color: lightblue");

        components.add(label, 0, 0);
        components.add(error,0,2);

        // Add some style to the ui
        components.setHgap(10);
        components.setVgap(10);
        components.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(components,450,100);
        stage.setScene(scene);
        stage.setTitle("Third User Panel");
        stage.show();
    }
    @Override
    public void getNotification(observer a,int am) throws IOException {
        label.setText("the bid is now "+am+" by "+a.getName());
        if(a.getName() == this.name){
            error.setText("Congrats! you "+this.name+" is the higest bidder");
        }else{
            error.setText("Your bid has been over ruled");
        }
    }

    @Override
    public void getError(observer a,int am) {
        if(a.getName()==this.name){
            error.setText("Your bid "+ am + " is not enough");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void reset() {
        label.setText("Bidding Situation");
        error.setText("Current State");
    }
}
