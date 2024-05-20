package org.example.lab3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class UserViewController implements Initializable {
    @FXML
    public Button btnFind;
    @FXML
    public TableView<Tour> tabTours;

    public ObservableList<Tour> filterList = FXCollections.observableArrayList();
    public Button btnShowAll;
    public ChoiceBox<String> cbTransport;
    public ChoiceBox<String> cbNutrition;
    public Spinner<Integer> spNumberDays;
    public TableColumn<Tour, String> colCountry;
    public TableColumn<Tour, String> colLocality;
    public TableColumn<Tour, String> colType;
    public TableColumn<Tour, String> colTransport;
    public TableColumn<Tour, String> colNutrition;
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

    ObservableList<String> transportList= FXCollections.observableArrayList("автобус","поезд", "самолет");
    ObservableList<String> nutritiontList = FXCollections.observableArrayList("без питания", "завтрак", "двухразовое", "трехразовое");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbTransport.setItems(transportList);
        cbNutrition.setItems(nutritiontList);
        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 60, 1);
        spNumberDays.setValueFactory(factory);

        colCountry.setCellValueFactory(new PropertyValueFactory<Tour, String>("country"));
        colLocality.setCellValueFactory(new PropertyValueFactory<Tour, String>("locality"));
        colType.setCellValueFactory(new PropertyValueFactory<Tour, String>("type"));
        colTransport.setCellValueFactory(new PropertyValueFactory<Tour, String>("transport"));
        colNutrition.setCellValueFactory(new PropertyValueFactory<Tour, String>("nutrition"));
        colNumberDays.setCellValueFactory(new PropertyValueFactory<Tour, Integer>("numberDays"));

        tabTours.setItems(list);

    }

    @FXML
    protected void onFindButtonClick() {

        System.out.println(cbTransport.getValue());
        System.out.println(cbNutrition.getValue());
        System.out.println(spNumberDays.getValue());


        if (cbTransport.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Транспорт от' не заполнено").showAndWait();
            return;
        }
        if (cbNutrition.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Поле 'Вид питания' не заполнено").showAndWait();
            return;
        }

        filterList.clear();
        for (Tour t : list) {
            if (t.getTransport().equals(cbTransport.getValue()) &&
                    t.getNutrition().equals(t.getNutrition()) &&
                    t.getNumberDays() == spNumberDays.getValue()
            ) {
                filterList.add(t);
            }
        }
        tabTours.setItems(filterList);
    }

    @FXML
    protected void onShowAllButtonClick() {
        tabTours.setItems(list);
    }
}
