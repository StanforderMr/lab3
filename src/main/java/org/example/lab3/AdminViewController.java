package org.example.lab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnDelete;
    @FXML
    public TableColumn<Tour, String> colCountry;
    @FXML
    public TableView<Tour> tabTours;
    @FXML
    public TableColumn<Tour, String> colLocality;
    @FXML
    public TableColumn<Tour, String> colType;
    @FXML
    public TableColumn<Tour, String> colTransport;
    @FXML
    public TableColumn<Tour, String> colNutrition;
    @FXML
    public TableColumn<Tour, Integer> colNumberDays;

    ObservableList<Tour> list = FXCollections.observableArrayList(
            new Tour("Испания", "Барселона", "отдых", "самолет", "без питания", 12),
            new Tour("Франция", "Париж", "экскурсия", "автобус", "завтрак", 5),
            new Tour("Литва", "Вильнюс", "шопинг", "поезд", "без питания", 2),
            new Tour("Италия", "Рим", "отдых", "автобус", "двухразовое", 14),
            new Tour("Испания", "Мадрид", "шопинг", "автобус", "завтрак", 20),
            new Tour("Китай", "Пекин", "лечение", "поезд", "трехразовое", 16),
            new Tour("Боливия", "Ла-Пас", "Отдых", "самолет", "без питания", 7),
            new Tour("США", "Лос-Анжелес", "экскурсия", "самолет", "завтрак", 18),
            new Tour("Украина", "Одесса", "отдых", "поезд", "двухразовое", 9)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCountry.setCellValueFactory(new PropertyValueFactory<Tour, String>("country"));
        colLocality.setCellValueFactory(new PropertyValueFactory<Tour, String>("locality"));
        colType.setCellValueFactory(new PropertyValueFactory<Tour, String>("type"));
        colTransport.setCellValueFactory(new PropertyValueFactory<Tour, String>("transport"));
        colNutrition.setCellValueFactory(new PropertyValueFactory<Tour, String>("nutrition"));
        colNumberDays.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("numberDays"));
        tabTours.setItems(list);
    }

    @FXML
    protected void onAddButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("edit-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 380);
        Stage userStage = new Stage();
        userStage.setTitle("Добавление нового тура");
        userStage.setScene(scene);
        EditViewController editController =  fxmlLoader.getController();
        editController.setAdminViewController(this);
        userStage.show();
    }

    @FXML
    protected void onDeleteButtonClick() {
        Tour t = tabTours.getSelectionModel().getSelectedItem();
        list.remove(t);
    }

    public void addTour(Tour t) {
        list.add(t);
    }
}
