package cn.hykd.userService.repository;

import cn.hykd.base.repository.BizRepository;
import cn.hykd.userService.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BizRepository<UserInfo,Long> {
}
