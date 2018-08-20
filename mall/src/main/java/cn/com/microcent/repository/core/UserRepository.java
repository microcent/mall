package cn.com.microcent.repository.core;

import cn.com.microcent.model.core.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/8/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
