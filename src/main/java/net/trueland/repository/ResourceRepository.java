package net.trueland.repository;

import net.trueland.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description 资源
 * @Date 2020/7/7 20:17
 * @Author dengxiaoyu
 */
public interface ResourceRepository extends JpaRepository<Resource, Integer>, JpaSpecificationExecutor<Resource> {
    /**
     * 根据角色id获取菜单集合
     *
     * @param roleId
     * @return
     */
    @Query(value = "SELECT re.* FROM t_role r, t_role_resource rr, t_resource re WHERE rr.`role_id` = r.`id` AND rr" +
            ".`resource_id` = re.`id` and r.`id`=?1", nativeQuery = true)
    List<Resource> findByRoleId(int roleId);
}
