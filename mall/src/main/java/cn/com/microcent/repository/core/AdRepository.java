package cn.com.microcent.repository.core;

import cn.com.microcent.domain.core.Ad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    Page<Ad> findByPosition(int position, Pageable pageable);

}
