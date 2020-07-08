package net.trueland.entity;

import lombok.Data;

import javax.persistence.*;

/**
*  t_user_role
* @author dengxiaoyu
*/
@Entity
@Data
@Table(name="t_user_role")
public class UserRole {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
    * 角色id
    */
    @Column(name = "role_id")
    private Integer roleId;

    /**
    * 用户id
    */
    @Column(name = "user_id")
    private Integer userId;

}
