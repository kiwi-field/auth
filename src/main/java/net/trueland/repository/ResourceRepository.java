package net.trueland.repository;

import net.trueland.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description 资源
 * @Date 2020/7/7 20:17
 * @Author dengxiaoyu
 */
public interface ResourceRepository extends JpaRepository<Resource, Integer>, JpaSpecificationExecutor<Resource> {
}
