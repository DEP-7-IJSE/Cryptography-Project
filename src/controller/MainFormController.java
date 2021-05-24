package controller;

import com.sun.javafx.scene.input.KeyCodeMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;
    public Button btnEncrypt;
    public Button btnDecrypt;

    public void initialize(){

        btnEncrypt.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    encryptOnAction(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnDecrypt.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    decryptOnAction(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void encryptOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("/view/EncryptionForm.fxml", "Encryption Window");
    }

    public void decryptOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("/view/DecryptionForm.fxml", "Decryption Window");
    }

    private void loadForm(String loadFormURL, String windowName) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource(loadFormURL));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(windowName);
        stage.centerOnScreen();
        stage.initOwner(this.root.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}