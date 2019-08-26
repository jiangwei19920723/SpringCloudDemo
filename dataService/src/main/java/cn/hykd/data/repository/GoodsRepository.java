package cn.hykd.data.repository;

import cn.hykd.base.repository.BizRepository;
import cn.hykd.data.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends BizRepository<Goods,Long> {
}
