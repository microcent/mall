package cn.com.microcent.repository;

import cn.com.microcent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/8/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
