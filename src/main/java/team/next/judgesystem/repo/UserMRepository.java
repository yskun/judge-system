package team.next.judgesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import team.next.judgesystem.model.UserMEntity;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
public interface UserMRepository extends JpaRepository<UserMEntity, Integer> {
    public UserMEntity findByEmail(String email);
}
