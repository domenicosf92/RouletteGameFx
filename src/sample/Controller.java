package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    String typeOfBet, color;
    Game roulette = new Game("Casino Bellini", 10000);
    Player player = new Player("Domenico", 500);
    int extractNumber = roulette.random();

    @FXML
    private TextField numberOfBet;

    @FXML
    private TextField number;

    @FXML
    private TextField amount;

    @FXML
    private TextField amount2;

    @FXML
    private TextField amount3;

    @FXML
    private Button send1;

    @FXML
    private Button send2;

    @FXML
    private Button send3;

    @FXML
    private CheckBox even;

    @FXML
    private CheckBox odd;

    @FXML
    private CheckBox red;

    @FXML
    private CheckBox black;

    @FXML
    private Button bet1;

    @FXML
    private Button bet2;

    @FXML
    private Button bet3;

    @FXML
    private TextArea output;

    @FXML
    void bet1Pressed(ActionEvent event) {
        if (roulette.checkNum(player)) {
            this.output.setText(roulette.toString() + "\nExtracted number: " + extractNumber + "\n" + player.toString() + "\nYou win");
        }else {
            this.output.setText(roulette.toString() + "\nExtracted number: " + extractNumber + "\n" + player.toString() + "\nYou lose");
        }
    }

    @FXML
    void bet2Pressed(ActionEvent event) {
        int bet = Integer.parseInt(amount2.getText());
        try {
            if (roulette.checkOddOrEven(player, typeOfBet, bet)) {
                this.output.setText(roulette.toString() + "\nExtracted number: " + extractNumber + "\n" + player.toString() + "\nYou win" + bet * 10 + "€");
            } else {
                this.output.setText(roulette.toString() + "\nExtracted number: " + extractNumber + "\n" + player.toString() + "\nYou lose" + bet + "€");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void bet3Pressed(ActionEvent event) {
        int bet1 = Integer.parseInt(amount3.getText());
        try {
            if (roulette.checkByColor(player, color, bet1)) {
                this.output.setText(roulette.toString() + "\nExtracted number: " + extractNumber + "\n" + player.toString() + "\nYou win" + bet1 * 9 + "€");
            } else {
                this.output.setText(roulette.toString() + "\nExtracted number: " + extractNumber + "\n" + player.toString() + "\nYou lose" + bet1 + "€");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void blackSelected(ActionEvent event) {
        this.color = "Black";
    }

    @FXML
    void redSelected(ActionEvent event) {
        this.color = "Red";
    }

    @FXML
    void evenSelected(ActionEvent event) {
        this.typeOfBet = "Even";
    }

    @FXML
    void oddSelected(ActionEvent event) {
        this.typeOfBet = "Odd";
    }

    @FXML
    void pressedSend1(ActionEvent event) {
        int nOB = Integer.parseInt(numberOfBet.getText());
    }

    @FXML
    void pressedSend3(ActionEvent event) {
        int num = Integer.parseInt(number.getText());
        int money = Integer.parseInt(amount.getText());
        player.addTo(num,money);
        this.output.setText(roulette.toString());
    }
}
