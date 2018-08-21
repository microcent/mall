package cn.com.microcent.repository.core;

import cn.com.microcent.domain.core.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/8/17.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
