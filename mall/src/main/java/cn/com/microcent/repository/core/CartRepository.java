package cn.com.microcent.repository.core;

import cn.com.microcent.domain.core.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(long userId);

    @Modifying
    @Query("update Cart a set a.isChecked = ?1 where a.productId in (?2)")
    void updateChecked(boolean isChecked, List<Long> productIds);

}
