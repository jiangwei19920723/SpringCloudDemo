package cn.hykd.userService.domain;

import cn.hykd.base.domain.BizDomain;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name ="Login")
public class Login extends BizDomain<Long> {
    @NotBlank
    private String loginName;
    @NotBlank
    private String password;
    private Date loginTime;
    private Long userId;
    private String token;
}
