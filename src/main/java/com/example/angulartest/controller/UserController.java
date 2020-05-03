package com.example.angulartest.controller;

import com.example.angulartest.dto.UserDto;
import com.example.angulartest.dto.UserGetDto;
import com.example.angulartest.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class UserController {
    private static final String EMAIL = "admin@gmail.com";
    private static final String PASSWORD = "123456";
    private static final String ACCESS_TOKEN = "abcdefghiklmn";
    private List<UserGetDto> userGetDtoList;
    @Autowired
    private PermissionService permissionService;

    public UserController() {
        userGetDtoList = initUserDto();
    }

    private List<UserGetDto> initUserDto() {
        List<UserGetDto> list = new ArrayList<>();
         String email = "email";
         String userName = "userName";
        for (int i = 1; i <= 100; i++)
            list.add(new UserGetDto(Long.valueOf(i), UUID.randomUUID().toString(), email + i, userName + i));
        return list;
    }

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

    /**
     * Phân trang trong List người dùng
     * Tìm kiếm đợi 1 lúc người dùng
     *
     * @param keyWord
     * @param page
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity getByPage(@RequestParam("keyWord") String keyWord, @RequestParam("page") String page) {
        List<UserGetDto> list = new ArrayList<>();
        int pageNum = Integer.parseInt(page);
        int limitNum = pageNum * 10;
        int limitStartNum = (pageNum - 1) * 10;
        if (!keyWord.isEmpty()) {
            for (int i = 0; i < userGetDtoList.size(); i++) {
                UserGetDto userGetDto = userGetDtoList.get(0);
                String email = userGetDto.getEmail();
                if (email.startsWith(keyWord)) {
                    list.add(userGetDto);
                }
            }
        } else {
            for (int i = limitStartNum; i < limitNum; i++) {
                list.add(userGetDtoList.get(i));
            }
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
