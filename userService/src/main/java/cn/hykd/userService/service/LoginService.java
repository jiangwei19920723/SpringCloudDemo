package cn.hykd.userService.service;

import cn.hykd.base.service.BizService;
import cn.hykd.userService.domain.Login;
import cn.hykd.userService.domain.UserInfo;
import cn.hykd.userService.repository.LoginRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@Service
public class LoginService extends BizService<Login,Long> {
    @Autowired
    private LoginRepository repository;
    @Autowired
    private UserService userService;

    public UserInfo save(@Valid UserInfo info) {
        userService.save(info);
        info.getLogin().setUserId(info.getId());
        Login login = repository.findByLoginName(info.getLogin().getLoginName());
        if (login !=null){
            throw new RuntimeException("登录名已存在！");
        }
        info.getLogin().setPassword(DigestUtils.md5Hex(info.getLogin().getPassword()));
        repository.save(info.getLogin());
        return info;
    }

    @Override
    public Login update(@Valid Login login) throws SQLException {
        Login login1 = repository.findByLoginName(login.getLoginName());
        if (login1 == null){
            return super.update(login);
        }else {
            throw new RuntimeException("登录名已存在！");
        }
    }

    public UserInfo login(Login login){
        Login login1 = repository.findByLoginName(login.getLoginName());
        if (login1 == null){
            throw new RuntimeException("登录名不存在！");
        }
        if (login1.getPassword().equals(DigestUtils.md5Hex(login.getPassword()))){
            String uuid = UUID.randomUUID().toString();
            login1.setToken(uuid);
            login1.setLoginTime(new Date());
            save(login1);
            UserInfo userInfo = userService.findOne(login1.getUserId());
            userInfo.setLogin(login1);
            return userInfo;
        }else {
            throw new RuntimeException("密码错误！");
        }
    }

    public Login findByUserId(Long id){
        return repository.findByUserId(id);
    }

    public UserInfo findByToken(String token){
        Login login = repository.findByToken(token);
        if (login == null){
            return null;
        }
        UserInfo userInfo = userService.findOne(login.getUserId());
        userInfo.setLogin(login);
        return userInfo;
    }
}
