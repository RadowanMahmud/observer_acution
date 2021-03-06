package youtbe;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.FirstUser;
import user.SecondUser;
import user.ThirdUser;
import user.observer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    Button first_user,second_user,third_user,reset_button;
    @FXML
    TextField bidding_amount;
    @FXML
    Label current_bidder,current_bid_amount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        observer a= null;
        try {
            a = new FirstUser("First User");
        } catch (IOException e) {
            e.printStackTrace();
        }
        observer b= null;
        try {
            b = new SecondUser("Second User");
        } catch (IOException e) {
            e.printStackTrace();
        }
        observer c= null;
        try {
            c = new ThirdUser("Third User");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner cin=new Scanner(System.in);
        auction u = new auction();
        u.subscribe(a);
        u.subscribe(b);
        u.subscribe(c);


        observer finalA = a;
        first_user.setOnAction(e -> {
            try {
                int ch=Integer.parseInt(bidding_amount.getText());
                if(u.upload(finalA,ch)){
                    current_bidder.setText(finalA.getName());
                    current_bid_amount.setText(String.valueOf(ch));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        observer finalB = b;
        second_user.setOnAction(e -> {
            try {
                int ch=Integer.parseInt(bidding_amount.getText());
                if(u.upload(finalB,ch)){
                    current_bidder.setText(finalB.getName());
                    current_bid_amount.setText(String.valueOf(ch));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        observer finalC = c;
        third_user.setOnAction(e -> {
            try {
                int ch=Integer.parseInt(bidding_amount.getText());
                if(u.upload(finalC,ch)){
                    current_bidder.setText(finalC.getName());
                    current_bid_amount.setText(String.valueOf(ch));
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        reset_button.setOnAction(e->{
            current_bidder.setText("Current Bidder");
            current_bid_amount.setText("Current Bid Amount");
            bidding_amount.clear();
            try {
                u.ressetAuction();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


    }
}
