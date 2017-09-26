package team.next.judgesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.next.judgesystem.model.ReportEntity;

import java.util.List;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@Repository
public interface ReportRepository extends JpaRepository<ReportEntity,Integer> {
    List<ReportEntity> findAllByReportUrlAndReportIp(String Url,String Ip);
}
