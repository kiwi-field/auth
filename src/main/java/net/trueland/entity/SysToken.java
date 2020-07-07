package net.trueland.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
*  t_token
* @author 大狼狗 2020-07-07
*/
@Entity
@Data
@Table(name="t_sys_token")
public class SysToken {


    @Id
    @GeneratedValue
    /**
    * 用户id
    */
    @Column(name = "user_id")
    private Integer userId;

    /**
    * 过期时间
    */
    @Column(name = "expire_time")
    private Date expireTime;

    /**
    * token
    */
    @Column(name = "token")
    private String token;

    /**
    * 更新时间
    */
    @Column(name = "update_time")
    private Date updateTime;

}
