package net.trueland.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
*  t_sys_token
* @author dengxiaoyu
*/
@Entity
@Data
@Table(name="t_sys_token")
public class SysToken {


    @Id
    /**
    * 用户id
    */
    @Column(name = "user_id")
    private Integer userId;

    /**
    * 过期时间
    */
    @Column(name = "expire_time")
    private LocalDateTime expireTime;

    /**
    * token
    */
    @Column(name = "token")
    private String token;

    /**
    * 更新时间
    */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

}
