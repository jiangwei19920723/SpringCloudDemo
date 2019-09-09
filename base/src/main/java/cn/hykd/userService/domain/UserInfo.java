package cn.hykd.userService.domain;

import cn.hykd.base.domain.BizDomain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name ="user_info")
public class UserInfo extends BizDomain<Long> {
    @NotBlank
    private String name;//用户名称
    @NotNull
    private Integer age;//年龄
    @NotBlank
    private String sex;//性别
    private String job;//工作
    @NotNull
    private Date birthday;//生日
    @Transient
    private Login login;
}
