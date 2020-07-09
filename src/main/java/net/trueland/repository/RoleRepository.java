package net.trueland.repository;

import net.trueland.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 角色Repository接口
 * @author Administrator
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    /**
     * 根据用户id查角色集合
     *
     * @param userId
     * @param companyId
     * @return
     */
    @Query(value = "SELECT r.* FROM t_user u,t_role r,t_user_role ur WHERE ur.`user_id`=u.`id` " +
            "AND ur.`role_id`=r.`id` AND u.`id`=?1 and r.company_id = ?2 and u.company_id = ?2", nativeQuery = true)
    List<Role> findByUserId(Integer userId, Integer companyId);
}
