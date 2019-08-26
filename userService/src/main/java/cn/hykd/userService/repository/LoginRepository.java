package cn.hykd.userService.repository;

import cn.hykd.base.repository.BizRepository;
import cn.hykd.userService.domain.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends BizRepository<Login,Long> {
    Login findByLoginName(String loginName);
    Login findByUserId(Long userId);
    Login findByToken(String token);
}
