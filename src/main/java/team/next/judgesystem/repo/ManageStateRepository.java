package team.next.judgesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.next.judgesystem.model.ManageStateEntity;
import team.next.judgesystem.model.ReportEntity;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@Repository
public interface ManageStateRepository  extends JpaRepository<ManageStateEntity,Integer> {
    ManageStateEntity findById(Integer id);
}
