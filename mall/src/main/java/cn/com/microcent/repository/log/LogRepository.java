package cn.com.microcent.repository.log;

import cn.com.microcent.model.log.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/8/17.
 */
public interface LogRepository extends JpaRepository<Log, Long> {
}
