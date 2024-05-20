package org.example.lab3;

import java.io.Serializable;

public class Tour implements Serializable {
    private String country;
    private String locality;
    private String type;
    private String transport;
    private String nutrition;
    private int numberDays;

    public Tour() {
    }

    public Tour(String country, String locality, String type, String transport, String nutrition, int numberDays) {
        this.country = country;
        this.locality = locality;
        this.type = type;
        this.transport = transport;
        this.nutrition = nutrition;
        this.numberDays = numberDays;
    }

    @Override
    public String toString() {
        return "страна - '" + country + '\'' +
                ", населенный пункт - '" + locality + '\'' +
                ", тип - '" + type + '\'' +
                ", транспорт - '" + transport + '\'' +
                ", питание - '" + nutrition + '\'' +
                ", количество дней - " + numberDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
