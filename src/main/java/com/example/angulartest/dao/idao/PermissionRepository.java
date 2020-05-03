package com.example.angulartest.dao.idao;

import com.example.angulartest.dao.entities.PermissionEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface PermissionRepository extends JpaRepository<PermissionEnt, Long> {

    /**
     * Lấy sub permission đầu tiên
     *
     * @param parentId
     * @param isFirstNav default true
     * @return
     */

    PermissionEnt getByParentIdAndIsFirstNavAndIsAllowTrue(Long parentId, Boolean isFirstNav);

    /**
     * Lấy permission gốc đầu tiên của hệ thống
     * next default not null
     *
     * @return
     */
    PermissionEnt getByParentNullAndNextIsNotNullAndIsFirstNavTrueAndIsAllowTrue();
}
