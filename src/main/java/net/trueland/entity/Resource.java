package net.trueland.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Description
 * @Date 2020/7/7 19:50
 * @Author dengxiaoyu
 */
@Data
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
