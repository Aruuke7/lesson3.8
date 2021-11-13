package com.example.lesson38.model;

public class Drugs {
    public static final int LayoutOne = 0;
    public static final int LayoutTwo = 1;
    private int viewType;


    private String group;
    private String drug;
    private String disease;
    private int icon;

    public Drugs(int viewType, String disease) {
        this.viewType = viewType;
        this.disease = disease;
    }

    public Drugs(int viewType, String group, String drug, int icon) {
        this.viewType = viewType;
        this.group = group;
        this.drug = drug;
        this.icon = icon;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
