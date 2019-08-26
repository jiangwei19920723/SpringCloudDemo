package cn.hykd.data.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name="user-Service")
@RequestMapping("login")
public interface FeignService {

    @GetMapping("/token")
    Map<String,Object> getUserInfo(String token);
}
