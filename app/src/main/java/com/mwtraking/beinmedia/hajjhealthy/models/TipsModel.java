package com.mwtraking.beinmedia.hajjhealthy.models;

public class TipsModel {
    private  String name;
    private  String tips;

    public TipsModel(String name, String tips) {
        this.name = name;
        this.tips = tips;
    }


    public TipsModel(String tips) {
        this.tips = tips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
