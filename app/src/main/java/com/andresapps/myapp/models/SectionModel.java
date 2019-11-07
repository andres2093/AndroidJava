package com.andresapps.myapp.models;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionModel {

    private int id;
    private String name;
    private String version;
    private String year;
    private String features;
    private String imgSrc;

    public SectionModel(JSONObject jsonObject){
        try {
            this.id = jsonObject.getInt("id");
            this.name = jsonObject.getString("name");
            this.version = jsonObject.getString("version");
            this.year = jsonObject.getString("year");
            this.features = jsonObject.getString("features");
            this.imgSrc = jsonObject.getString("imgSrc");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public SectionModel(String name) {
        this.id = -1;
        this.name = name;
        this.version = "";
        this.year = "";
        this.features = "";
        this.imgSrc = "-1";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getYear() {
        return year;
    }

    public String getFeatures() {
        return features;
    }

    public String getImgSrc() {
        return imgSrc;
    }
}
