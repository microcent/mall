package cn.com.microcent.service;

import cn.com.microcent.domain.core.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
public interface CategoryService {

    List<Category> findAll();

    List<Category> findIndexChannel();

    List<Category> findIndexFloor();

    List<Category> findByParentId(long parentId);

    List<Category> findL1();

    Category findById(long id);

}
