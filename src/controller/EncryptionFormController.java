package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class EncryptionFormController {

    public TextField txtText;
    public TextField txtKey;
    public TextField txtCipherText;

    public void encryptOnAction(ActionEvent actionEvent) {
        String text = txtText.getText();
        String key = txtKey.getText();

        if(text.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter valid text", ButtonType.OK).show();
            txtText.requestFocus();
            return;
        }
        if(key.trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Please enter valid key",ButtonType.OK).show();
            txtKey.requestFocus();
            return;
        }
        text+=key;
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
        txtCipherText.setText("^&5"+cipheText+"^%");
    }
}
