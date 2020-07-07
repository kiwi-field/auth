package net.trueland.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色实体
 * @author dengxiaoyu
 *
 */
@Entity
@Table(name="t_role")
@Data
public class Role {

    /**
     * 编号
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    /**
     * 角色名称
     */
	@Column(length=50)
	private String name;


    /**
     * 备注
     */
	@Column(length=1000)
	private String remarks;
}
