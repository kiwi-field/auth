package net.trueland.entity;

import lombok.Data;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
*  企业信息表
* @author dengxiaoyu 2020-07-09
*/
@Entity
@Data
@Table(name="t_company")
@ApiModel("企业信息表")
public class Company{

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    @Column(name = "id")
    private Integer id;

    /**
    * 企业全称
    */
    @ApiModelProperty("企业全称")
    @Column(name ="name")
    private String name;

    /**
    * 企业简称
    */
    @ApiModelProperty("企业简称")
    @Column(name ="short_name")
    private String shortName;

    /**
    * 企业所在城市
    */
    @ApiModelProperty("企业所在城市")
    @Column(name ="city")
    private String city;

    /**
    * 联系人
    */
    @ApiModelProperty("联系人")
    @Column(name ="contact")
    private String contact;

    /**
    * 手机号
    */
    @ApiModelProperty("手机号")
    @Column(name ="phone")
    private String phone;

    /**
    * 邮箱
    */
    @ApiModelProperty("邮箱")
    @Column(name ="email")
    private String email;

    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    @Column(name ="creater_time")
    private Date createrTime;

    /**
    * 0 启用 1 禁用
    */
    @ApiModelProperty("0 启用 1 禁用")
    @Column(name ="disabled")
    private boolean disabled;
}
