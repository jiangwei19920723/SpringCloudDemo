package cn.hykd.data.service;

import cn.hykd.base.service.BizService;
import cn.hykd.data.client.UserClient;
import cn.hykd.data.domain.Goods;
import cn.hykd.data.repository.GoodsRepository;
import cn.hykd.userService.domain.UserInfo;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GoodsService extends BizService<Goods,Long> {
    @Autowired
    private GoodsRepository repository;
    @Autowired
    private UserClient userClient;

    public List<Goods> saves(List<Goods> goodss){
        for (Goods goods: goodss) {
            super.save(goods);
        }
        return goodss;
    }

    @TxcTransaction(propagation = DTXPropagation.REQUIRED)
    public List<UserInfo> users(){
        Goods goods = new Goods();
        goods.setGoodsCode("code10");
        goods.setGoodsFactory("重庆");
        goods.setGoodsName("货物");
        goods.setGoodsNumber(123);
        goods.setGoodsPrice(12.0);
        goods.setGoodsType("大");
        goods.setGoodsUnit("件");
        repository.save(goods);
        UserInfo info = new UserInfo();
        info.setAge(12);
        info.setBirthday(new Date());
        info.setJob("java");
        info.setSex("男");
        info.setName("蒋维");
        userClient.add(info);
        if (1==1){
            throw new IllegalStateException("by exFlag");
        }
        List<UserInfo> userInfos = userClient.list();
        return userInfos;
    }
}
