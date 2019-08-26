package cn.hykd.base.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Wei Han on 2016/2/4.
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BizDomain<I extends Serializable> extends BaseDomain<I> {

    @LastModifiedDate
    private Date updateTime;

    @CreatedDate
    @Column(updatable = false)
    private Date createTime;

    private boolean deleted;

}
