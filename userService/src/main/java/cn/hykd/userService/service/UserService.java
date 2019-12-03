package cn.hykd.userService.service;

import cn.hykd.base.service.BizService;
import cn.hykd.userService.domain.UserInfo;
import cn.hykd.userService.repository.UserRepository;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BizService<UserInfo,Long> {
    @Autowired
    private UserRepository repository;

    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    public UserInfo save(UserInfo userInfo) {
        return super.save(userInfo);
    }
}
