package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import static lk.ijse.crypto.CryptoAlgo.encrypt;

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
        txtCipherText.setText(encrypt(text,key));
    }

    public void keyEnteredOnAction(ActionEvent actionEvent) {
        encryptOnAction(null);
    }
}