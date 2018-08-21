package cn.com.microcent.service.impl;

import cn.com.microcent.domain.core.Issue;
import cn.com.microcent.repository.core.IssueRepository;
import cn.com.microcent.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> findAll() {
        return this.issueRepository.findAll();
    }

}
