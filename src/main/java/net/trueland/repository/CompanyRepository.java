package net.trueland.repository;

import net.trueland.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
*  企业信息表
* @author dengxiaoyu 2020-07-09
*/
@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {



}
