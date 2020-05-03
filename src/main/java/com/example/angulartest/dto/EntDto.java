package com.example.angulartest.dto;

import java.io.Serializable;

public class EntDto implements Serializable {
    private Long id;

    private String uuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
