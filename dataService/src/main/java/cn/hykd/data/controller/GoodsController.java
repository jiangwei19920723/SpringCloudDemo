package cn.hykd.data.controller;

import cn.hykd.data.client.UserClient;
import cn.hykd.data.domain.Goods;
import cn.hykd.data.service.GoodsService;
import cn.hykd.userService.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    @PostMapping("/add")
    public List<Goods> add(@RequestBody List<Goods> goodss) {
        return service.saves(goodss);
    }

    @GetMapping("query")
    public Map<String ,Object> query(){
        List<Goods> goodsList = service.findAll();
        Map<String ,Object> map = new HashMap<>();
        map.put("data",goodsList);
        map.put("code",0);
        map.put("count",goodsList.size());
        return map;
    }

    @GetMapping("/page/query")
    public List<Goods> page(){
        return null;
    }

    @GetMapping("/users")
    public List<UserInfo> users(){
        return service.users();
    }
}
