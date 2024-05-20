package org.example.lab3;

import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    public Button btnAdmin;
    public Button btnUser;

    @FXML
    protected void onUserButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("user-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 450);
        Stage userStage = new Stage();
        userStage.setTitle("Режим пользователя");
        userStage.setScene(scene);
        userStage.show();

        Stage stage = (Stage) btnUser.getScene().getWindow();
        stage.hide();
    }

    @FXML
    protected void onAdminButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("admin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 450);
        Stage userStage = new Stage();
        userStage.setTitle("Режим администратора");
        userStage.setScene(scene);
        userStage.show();

        Stage stage = (Stage) btnAdmin.getScene().getWindow();
        stage.hide();
    }
}