package net.trueland.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
*  角色资源关系表
* @author dengxiaoyu
*/
@Entity
@Data
@Table(name="t_role_resource")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    /**
     * 资源id
     */
    @Column(name = "resource_id")
    private Integer resourceId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

}
