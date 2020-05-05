package com.example.angulartest.dao.entities;


import com.example.angulartest.dto.EntDto;
import com.example.angulartest.dto.PermissionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResultUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permission", uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class PermissionEnt extends EntBase<PermissionDto> {

    private String code;
    private String label;
    private String iconClass;
    private String description;
    private String href;
    private Boolean isShowOnMenu = false;
    private Boolean isAllow = true;
    private Boolean isFirstNav = false;

    @ManyToOne
    @JoinColumn(name = "parent")
    private PermissionEnt parent;

    @OneToMany(mappedBy = "parent")
    private List<PermissionEnt> children;

    @ManyToOne
    @JoinColumn(name = "next")
    private PermissionEnt next;


    @Override
    public PermissionDto getAsDto() {
        PermissionDto permissionDto = new PermissionDto();
        BeanUtils.copyProperties(this, permissionDto);
        return permissionDto;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getIconClass() {
        return iconClass;
    }

    public String getDescription() {
        return description;
    }

    public String getHref() {
        return href;
    }

    public Boolean getShowOnMenu() {
        return isShowOnMenu;
    }

    public Boolean getAllow() {
        return isAllow;
    }

    public com.example.angulartest.dao.entities.PermissionEnt getParent() {
        return parent;
    }

    public List<com.example.angulartest.dao.entities.PermissionEnt> getChildren() {
        return children;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setShowOnMenu(Boolean showOnMenu) {
        isShowOnMenu = showOnMenu;
    }

    public void setAllow(Boolean allow) {
        isAllow = allow;
    }

    public void setParent(PermissionEnt parent) {
        this.parent = parent;
    }

    public void setChildren(List<PermissionEnt> children) {
        this.children = children;
    }

    public Boolean getFirstNav() {
        return isFirstNav;
    }

    public void setFirstNav(Boolean firstNav) {
        isFirstNav = firstNav;
    }

    public PermissionEnt getNext() {
        return next;
    }

    public void setNext(PermissionEnt next) {
        this.next = next;
    }
}
