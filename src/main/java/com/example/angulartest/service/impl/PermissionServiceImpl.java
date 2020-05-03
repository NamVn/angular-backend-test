package com.example.angulartest.service.impl;

import com.example.angulartest.dao.entities.PermissionEnt;
import com.example.angulartest.dao.idao.PermissionRepository;
import com.example.angulartest.dto.PermissionDto;
import com.example.angulartest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    @Transactional
    public List<PermissionDto> getNavigationBar(String role) {
        role = role.trim();
        PermissionEnt firstNavPermissionEnt = permissionRepository.getByParentNullAndNextIsNotNullAndIsFirstNavTrueAndIsAllowTrue();
        if (firstNavPermissionEnt != null) {
            List<PermissionDto> firstNavPermissionDtoList = new ArrayList<>();
            PermissionDto firstNavPermissionDto = firstNavPermissionEnt.getAsDto();
            //   initFirstNav(firstNavPermissionEnt, firstNavPermissionDto);
            HashMap<Long, PermissionDto> hashMap = new HashMap();
            hashMap.put(firstNavPermissionDto.getId(), firstNavPermissionDto);
            firstNavPermissionDtoList.add(recursivePermission(firstNavPermissionEnt, firstNavPermissionDto, hashMap));

            PermissionEnt nextPermissionEnt = firstNavPermissionEnt.getNext();
            while (nextPermissionEnt != null) {
                firstNavPermissionDtoList.add(recursivePermission(nextPermissionEnt, nextPermissionEnt.getAsDto(), hashMap));
                nextPermissionEnt = nextPermissionEnt.getNext();
            }
            return firstNavPermissionDtoList;
        }
        return null;
    }

//    public void initFirstNav(PermissionEnt childNavbarPermissionEnt, PermissionDto parentNavBarPermissionDto) {
//        List<PermissionDto> children = parentNavBarPermissionDto.getChildrenDto();
//        if (children == null) children = new ArrayList<>();
//        PermissionEnt firstSubnav = permissionRepository.getByParentIdAndIsFirstNav(childNavbarPermissionEnt.getId(), true);
//        children.add(firstSubnav.getAsDto());
//        parentNavBarPermissionDto.setChildrenDto(children);
//    }

    @Override
    public PermissionDto recursivePermission(PermissionEnt childNavbarPermissionEnt, PermissionDto parentNavBarPermissionDto, HashMap<Long, PermissionDto> hashMap) {
        if (childNavbarPermissionEnt != null) {
            Long parentPermissionId = childNavbarPermissionEnt.getId();
            //Lấy subnav đầu tiên của 1 navbar
            PermissionEnt firstSubnav = permissionRepository.getByParentIdAndIsFirstNavAndIsAllowTrue(parentPermissionId, true);
            if (firstSubnav != null)
                addPermissionChildToPermissionParent(firstSubnav, parentNavBarPermissionDto, hashMap);
            PermissionEnt afterPermission = childNavbarPermissionEnt.getNext();
            if (afterPermission != null && afterPermission.getParent() != null) {
                PermissionDto parentAfterPermissionDto = hashMap.get(afterPermission.getParent().getId());
                addPermissionChildToPermissionParent(afterPermission, parentAfterPermissionDto, hashMap);
            }
        }
        return parentNavBarPermissionDto;
    }

    public void addPermissionChildToPermissionParent(PermissionEnt childNavbarPermissionEnt, PermissionDto parentNavBarPermissionDto, HashMap<Long, PermissionDto> hashMap) {
        PermissionDto childNavbarPermissionDto = childNavbarPermissionEnt.getAsDto();
        if (parentNavBarPermissionDto != null) {
            List<PermissionDto> children = parentNavBarPermissionDto.getChildrenDto();
            if (children == null) children = new ArrayList<>();
            children.add(childNavbarPermissionDto);
            parentNavBarPermissionDto.setChildrenDto(children);
            hashMap.put(childNavbarPermissionDto.getId(), childNavbarPermissionDto);
            recursivePermission(childNavbarPermissionEnt, childNavbarPermissionDto, hashMap);
        }
    }
}
