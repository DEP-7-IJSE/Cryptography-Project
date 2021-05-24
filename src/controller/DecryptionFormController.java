package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Random;

public class DecryptionFormController {
    public TextField txtText;
    public TextField txtKey;
    public TextField txtCipher;

    public void decryptOnAction(ActionEvent actionEvent) {
        String cipher = txtCipher.getText();
        String key = txtKey.getText();

        if(cipher.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter valid cipher", ButtonType.OK).show();
            txtCipher.requestFocus();
            return;
        }
        if(key.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter valid key",ButtonType.OK).show();
            txtKey.requestFocus();
            return;
        }
        if(cipher.length()<15){
            genRandomNumbers();
            return;
        }
        String dec = cipher.substring(3,cipher.length()-12);
        String reverseText="";
        for (int i = 0; i < dec.length(); i++) {
            int code=dec.charAt(i);
            code-=10;
            char originalChar = (char) code;
            reverseText+=originalChar;
        }
        String gotreversedText=reverseText.substring(2,reverseText.length()-3);
        String[] splitted=gotreversedText.split("@",3);
        String reversedKey="";
        for (int i = splitted[0].length()-1; i >=0; i--) {
            reversedKey+=splitted[0].charAt(i);
        }
        if(reversedKey.equals(txtKey.getText())){
            String text="";
            for (int i = splitted[1].length()-1; i >=0; i--) {
                text+=splitted[1].charAt(i);
            }
            txtText.setText(text);
        }else{
            genRandomNumbers();
            return;
        }
    }
    private void genRandomNumbers(){
        Random random= new Random();
        int randomInt = random.nextInt();
        char randomChar = (char) randomInt;
        txtText.setText(String.valueOf(randomChar));
    }

    public void keyEnteredOnAction(ActionEvent actionEvent) {
        decryptOnAction(null);
    }
}
