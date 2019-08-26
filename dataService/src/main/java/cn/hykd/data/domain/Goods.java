package cn.hykd.data.domain;

import cn.hykd.base.domain.BizDomain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "goods")
public class Goods extends BizDomain<Long> {
    private String goodsName;//货物名称
    private String goodsType;//货物类型
    private String goodsCode;//货物编号
    private String goodsUnit;//货物单位
    private String goodsFactory;//所属工厂
    private Integer goodsNumber;//货物数量
    private Double goodsPrice;//货物价格
}
