package cn.com.microcent.repository.log;

import cn.com.microcent.domain.log.BrowseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface BrowseLogRepository extends JpaRepository<BrowseLog, Long> {

    List<BrowseLog> findByUserId(long userId);

}
