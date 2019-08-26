package cn.hykd.base.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Wei Han on 2016/1/5.
 */
@Data
@MappedSuperclass
public abstract class BaseDomain<I extends Serializable> {

    @Id
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    private I id;
}
