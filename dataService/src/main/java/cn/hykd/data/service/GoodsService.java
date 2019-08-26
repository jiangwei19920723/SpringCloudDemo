package cn.hykd.data.service;

import cn.hykd.base.service.BizService;
import cn.hykd.data.domain.Goods;
import cn.hykd.data.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService extends BizService<Goods,Long> {
    @Autowired
    private GoodsRepository repository;

    public List<Goods> saves(List<Goods> goodss){
        for (Goods goods: goodss) {
            super.save(goods);
        }
        return goodss;
    }
}
