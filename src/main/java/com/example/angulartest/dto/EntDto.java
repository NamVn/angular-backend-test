package com.example.angulartest.dto;

import com.example.angulartest.dao.entities.EntBase;

import java.io.Serializable;

public abstract class EntDto<T> implements Serializable {
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

    public abstract T convertToEnt();
}
