package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import static lk.ijse.crypto.CryptoAlgo.decrypt;

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
        txtText.setText(decrypt(cipher,key));
    }

    public void keyEnteredOnAction(ActionEvent actionEvent) {
        decryptOnAction(null);
    }
}
