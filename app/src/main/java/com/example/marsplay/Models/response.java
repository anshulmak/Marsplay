package com.example.marsplay.Models;

import com.google.gson.annotations.SerializedName;

public class response {

    @SerializedName("response")
    private model model;


    public response(com.example.marsplay.Models.model model) {
        this.model = model;
    }

    public com.example.marsplay.Models.model getModel() {
        return model;
    }

    public void setModel(com.example.marsplay.Models.model model) {
        this.model = model;
    }
}
