package com.example.childhealthrecord.entity;

public enum VacStatus {
    DONE ("done"),
    ARRANGED ("arranged"),
    TO_ARRANGE ("to arrange"),
    NOT_APPLICABLE("n/a");

    private String name;

    VacStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
