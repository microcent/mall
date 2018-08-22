package cn.com.microcent.repository.core;

import cn.com.microcent.domain.core.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("from Order where userId=?1 and (?2=0 or status=?2)")
    List<Order> findByUserIdAndStatus(long userId, int status);

}
