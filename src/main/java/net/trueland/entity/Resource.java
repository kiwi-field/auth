package net.trueland.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description
 * @Date 2020/7/7 19:50
 * @Author dengxiaoyu
 */
@Data
@Entity
@Table(name="t_resource")
public class Resource {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 权限标识
     */
    @Column(name = "permission")
    private String permission;
}
