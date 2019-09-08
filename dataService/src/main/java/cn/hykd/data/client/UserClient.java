package cn.hykd.data.client;

import cn.hykd.userService.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-Service",path = "/user")
public interface UserClient {
    @GetMapping("/query")
    List<UserInfo> list();
}
