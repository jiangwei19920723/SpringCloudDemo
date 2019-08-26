package cn.hykd.userService.controller;

import cn.hykd.base.controller.BaseController;
import cn.hykd.userService.domain.Login;
import cn.hykd.userService.domain.UserInfo;
import cn.hykd.userService.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping("login")
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public UserInfo register(@RequestBody @Valid UserInfo info){
        return loginService.save(info);
    }

    @PutMapping("/update")
    public Login update(@RequestBody Login login){
        try {
            return loginService.update(login);
        } catch (SQLException e) {
            throw new RuntimeException(NOT_FUND);
        }
    }
    @PostMapping("/login")
    public UserInfo login(@RequestBody Login login){
        return loginService.login(login);
    }

    @GetMapping("/token")
    public UserInfo token(@RequestParam("token") String token){
        return loginService.findByToken(token);
    }
}
