package user;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class FirstUser implements observer {

    String name = "";

    Label label = new Label("My Label");
    GridPane components = new GridPane();

    public FirstUser(String na) throws IOException {
        name = na;
        Stage stage = new Stage();
        components.add(label, 0, 0);

        // Add some style to the ui
        components.setHgap(10);
        components.setVgap(10);
        components.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(components,350,100);
        stage.setScene(scene);
        stage.setTitle("First User Panel");
        stage.show();
    }

    @Override
    public void getNotification(observer a,int am) throws IOException {
        label.setText("This is sms and the bid is now "+am+" by "+a.getName());
    }

    @Override
    public void getError() {

    }

    @Override
    public String getName() {
        return this.name;
    }
}
