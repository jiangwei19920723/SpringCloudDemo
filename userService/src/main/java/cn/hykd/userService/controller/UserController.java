package cn.hykd.userService.controller;

import cn.hykd.base.controller.BaseController;
import cn.hykd.userService.domain.UserInfo;
import cn.hykd.userService.service.LoginService;
import cn.hykd.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @PostMapping("/add")
    public UserInfo add(@RequestBody @Valid UserInfo info){
        return userService.save(info);
    }
    @PutMapping("/update")
    public UserInfo update(@RequestBody @Valid UserInfo info){
        try {
            return userService.update(info);
        } catch (SQLException e) {
            throw new RuntimeException(NOT_FUND);
        }
    }
    @GetMapping("/query")
    public List<UserInfo> list(){
        List<UserInfo> infos = userService.findAll();
        for (UserInfo userInfo:infos) {
            userInfo.setLogin(loginService.findByUserId(userInfo.getId()));
        }
        return infos;
    }
    @DeleteMapping("/delete")
    public Map<String,String> delete(Long id){
        userService.delete(id);
        Map<String, String> map = new HashMap<>();
        map.put("result","sucess");
        return map;
    }
}
