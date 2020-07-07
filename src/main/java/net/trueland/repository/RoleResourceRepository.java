package net.trueland.repository;

import net.trueland.entity.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description
 * @Date 2020/7/7 20:18
 * @Author dengxiaoyu
 */
public interface RoleResourceRepository extends JpaRepository<RoleResource, Integer>, JpaSpecificationExecutor<RoleResource> {
}
