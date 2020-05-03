package com.example.angulartest.controller;


import com.example.angulartest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("")
    public ResponseEntity findByRoleName(@RequestParam("roleName") String roleName, @RequestParam("userName") String userName) {
        return new ResponseEntity(permissionService.getNavigationBar(userName), HttpStatus.OK);
    }
}
