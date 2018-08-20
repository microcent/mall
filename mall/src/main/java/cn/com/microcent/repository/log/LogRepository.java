package cn.com.microcent.repository.log;

import cn.com.microcent.domain.log.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
