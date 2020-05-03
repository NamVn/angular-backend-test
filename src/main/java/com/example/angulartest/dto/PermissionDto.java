package com.example.angulartest.dto;

import com.example.angulartest.dao.entities.PermissionEnt;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class PermissionDto extends EntDto {
    private String code;
    private String label;
    private String iconClass;
    private String href;
    private List<PermissionDto> childrenDto;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    public List<PermissionDto> getChildrenDto() {
        return childrenDto;
    }

    public void setChildrenDto(List<PermissionDto> childrenDto) {
        this.childrenDto = childrenDto;
    }


}
