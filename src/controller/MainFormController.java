package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;

    public void encryptOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("/view/EncryptionForm.fxml","Encryption Window");
    }

    public void decryptOnAction(ActionEvent actionEvent) throws IOException {
        loadForm("/view/DecryptionForm.fxml","Decryption Window");
    }

    private void loadForm(String loadFormURL,String windowName) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource(loadFormURL));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.setTitle(windowName);
        stage.centerOnScreen();
        stage.initOwner(this.root.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}