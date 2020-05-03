package com.example.angulartest.dto;

public class ProductDto {
    private Long id;
    private String uuid;
    private String name;
    private String code;
    private String description;
    private Boolean isChecked;
    private Boolean isProblem;
    private String note;

    public ProductDto(Long id, String uuid, String name, String code, String description, Boolean isChecked, Boolean isProblem, String note) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.description = description;
        this.isChecked = isChecked;
        this.isProblem = isProblem;
        this.note = note;
    }

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public Boolean getProblem() {
        return isProblem;
    }

    public void setProblem(Boolean problem) {
        isProblem = problem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
