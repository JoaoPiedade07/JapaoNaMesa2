package com.example.japaonamesa.Model.Spinner;

import java.io.Serializable;

public class SpinnerLocModel implements Serializable {

    String nameLocation;

    public SpinnerLocModel(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }
}
