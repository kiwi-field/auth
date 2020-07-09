package net.trueland.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * 用户实体
 * @author dengxiaoyu
 *
 */
@Entity
@Table(name="t_user")
@Data
public class User {
    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @NotEmpty(message="请输入用户名!")
	@Column(length=50)
	private String userName;

    /**
     * 密码
     */
	@NotEmpty(message="请输入密码!")
	@Column
	private String password;

    /**
     * 真实姓名
     */
	@Column(length=50)
	private String trueName;

    /**
     * 备注
     */
	@Column(length=1000)
	private String remarks;

	@Column(name = "company_id")
	private Integer companyId;

    /**
     * 所拥有的角色
     */
	@Transient
	private String roles;
}
