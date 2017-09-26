package team.next.judgesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import team.next.judgesystem.model.ReportEntity;
import team.next.judgesystem.model.WebinfoEntity;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
public interface WebinfoRepository  extends JpaRepository<WebinfoEntity,Integer> {
    public WebinfoEntity findByUrl(String Url);
}
