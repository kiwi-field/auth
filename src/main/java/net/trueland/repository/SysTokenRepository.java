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
    /**
     * 通过token查找
     * @param token
     * @return
     */
    SysToken findByToken(String token);

    /**
     * 通过userID查找
     * @param userId
     * @return
     */
    SysToken findByUserId(Integer userId);
}
