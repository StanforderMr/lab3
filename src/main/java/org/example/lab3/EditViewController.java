package org.example.lab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditViewController implements Initializable {

    private AdminViewController adminViewController;
    @FXML
    public TextField tfCountry;
    @FXML
    public TextField tfLocality;
    @FXML
    public ChoiceBox<String> cbType;
    @FXML
    public ChoiceBox<String> cbNutrition;
    @FXML
    public ChoiceBox<String> cbTransport;
    @FXML
    public TextField tfNumbersDays;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnCancel;

    ObservableList<String> typeList= FXCollections.observableArrayList("отдых", "экскурсии", "лечение", "шопинг", "круиз");
    ObservableList<String> transportList= FXCollections.observableArrayList("автобус","поезд", "самолет");
    ObservableList<String> nutritiontList = FXCollections.observableArrayList("без питания", "завтрак", "двухразовое", "трехразовое");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbTransport.setItems(transportList);
        cbNutrition.setItems(nutritiontList);
        cbType.setItems(typeList);
    }

    public void setAdminViewController(AdminViewController adminViewController) {
        this.adminViewController = adminViewController;
    }


    @FXML
    protected void onAddButtonClick() {
        int numberDays = 0;
        Tour t = new Tour();
        if (tfCountry.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Страна' не заполнено").showAndWait();
            return;
        }
        t.setCountry(tfCountry.getText());
        if (tfLocality.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Населенный пункт' не заполнено").showAndWait();
            return;
        }
        t.setLocality(tfLocality.getText());

        if(cbType.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Тип тура' не заполнено").showAndWait();
            return;
        }
        t.setType(cbType.getValue());

        if(cbTransport.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Транспорт' не заполнено").showAndWait();
            return;
        }
        t.setTransport(cbTransport.getValue());

        if(cbNutrition.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Питание' не заполнено").showAndWait();
            return;
        }
        t.setNutrition(cbNutrition.getValue());

        if (tfNumbersDays.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Количество дней' не заполнено").showAndWait();
            return;
        }

        try {
            numberDays = Integer.parseInt(tfNumbersDays.getText());
            t.setNumberDays(numberDays);
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Количество дней' содержит некорректное значение").showAndWait();
            return;
        }
        adminViewController.addTour(t);
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        stage.hide();
    }

    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.hide();
    }
}
