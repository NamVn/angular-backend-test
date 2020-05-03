package com.example.angulartest.controller;

import com.example.angulartest.dto.UserDto;
import com.example.angulartest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserController {
    private static final String EMAIL = "admin@gmail.com";
    private static final String PASSWORD = "123456";
    private static final String ACCESS_TOKEN = "abcdefghiklmn";
    @Autowired
    private PermissionService permissionService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto userDto) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if (userDto.getEmail().equals(EMAIL) && userDto.getPassword().equals(PASSWORD)) {
            List<String> authorities = new ArrayList();
            authorities.add("ROLE_MANAGER");
            authorities.add("ROLE_STAFF");
            map.put("accessToken", ACCESS_TOKEN);
            map.put("authenticated", true);
            map.put("expiresIn", 2 * 60);
            map.put("authorities", authorities);
            return new ResponseEntity(map, HttpStatus.OK);
        }
        map.put("error", "Login fail");
        return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
    }
}
