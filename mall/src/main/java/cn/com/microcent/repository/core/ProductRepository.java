package cn.com.microcent.repository.core;

import cn.com.microcent.domain.core.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByIsNew(boolean isNew, Pageable pageable);

    Page<Product> findByIsHot(boolean isHot, Pageable pageable);

    Page<Product> findByCategoryIdIn(List<Long> idList, Pageable pageable);

    Page<Product> findByCategoryId(long categoryId, Pageable pageable);

}
