package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class DecryptionFormController {
    public TextField txtText;
    public TextField txtKey;
    public TextField txtCipher;

    public void decryptOnAction(ActionEvent actionEvent) {
        String cipher = txtCipher.getText();
        String key = txtKey.getText();

        if(cipher.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter valid cipher", ButtonType.OK).show();
            txtText.requestFocus();
            return;
        }
        if(key.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter valid key",ButtonType.OK).show();
            txtKey.requestFocus();
            return;
        }
        /*text+=key;
        String reversedText="@@";
        for (int i = text.length()-1; i >=0; i--) {
            reversedText+=text.charAt(i);
        }
        reversedText+="@!!";
        String cipheText="";
        for (int i = 0; i < reversedText.length(); i++) {
            int code=reversedText.charAt(i);
            code+=10;
            char newChar = (char) code;
            cipheText+=newChar;
        }
        cipheText+=cipheText.hashCode();
        txtCipherText.setText("^&5"+cipheText+"^%");*/
        String dec = cipher.substring(3,cipher.length()-12);
        String reverseText="";
        for (int i = 0; i < dec.length(); i++) {
            int code=dec.charAt(i);
            code-=10;
            char originalChar = (char) code;
            reverseText+=originalChar;
        }
        System.out.println(reverseText.substring(2,reverseText.length()-3));
    }
}
