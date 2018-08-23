package cn.com.microcent.service.impl;

import cn.com.microcent.core.SystemConfig;
import cn.com.microcent.domain.core.Ad;
import cn.com.microcent.domain.core.Groupon;
import cn.com.microcent.repository.core.AdRepository;
import cn.com.microcent.repository.core.GrouponRepository;
import cn.com.microcent.service.AdService;
import cn.com.microcent.service.GrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class GrouponServiceImpl implements GrouponService {

    @Autowired
    private GrouponRepository grouponRepository;

    @Override
    public List<Groupon> findIndexGroupon() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(0, SystemConfig.getIndexGrouponLimit(), sort);
        Page<Groupon> page = this.grouponRepository.findAll(pageable);
        return page.getContent();
    }

}
