package net.trueland.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登录传输类
 * @author dengxiaoyu
 */
@Data
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotNull(message = "公司id不能为空")
    private Integer companyId;
}
