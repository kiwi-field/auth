package net.trueland.repository;

import net.trueland.entity.SysToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description
 * @Date 2020/7/7 20:19
 * @Author dengxiaoyu
 */
public interface SysTokenRepository extends JpaRepository<SysToken, Integer>, JpaSpecificationExecutor<SysToken> {
}
