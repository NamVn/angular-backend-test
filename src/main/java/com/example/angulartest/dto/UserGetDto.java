package com.example.angulartest.dto;

public class UserGetDto {
    private Long id;
    private String uuid;
    private String email;
    private String userName;


    public UserGetDto() {
    }

    public UserGetDto(Long id, String uuid, String email, String userName) {
        this.id = id;
        this.uuid = uuid;
        this.email = email;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
