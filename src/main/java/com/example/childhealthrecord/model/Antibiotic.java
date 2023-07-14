package com.example.childhealthrecord.model;

public enum Antibiotic {
    YES("yes"),
    NO("no");

    String name;

    Antibiotic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
